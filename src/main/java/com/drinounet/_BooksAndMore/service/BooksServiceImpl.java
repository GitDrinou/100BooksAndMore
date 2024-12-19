package com.drinounet._BooksAndMore.service;

import com.drinounet._BooksAndMore.datas.Book;
import com.drinounet._BooksAndMore.datas.BooksDTO;
import com.drinounet._BooksAndMore.repository.BooksRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksServiceImpl  implements BooksService {

    private final BooksRepository booksRepository;

    public BooksServiceImpl(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    @Override
    public List<Book> getAllBooks() {
        return booksRepository.findAll().stream()
                .map(this::convertToDTO)
                .toList();
    }

    @Override
    public void saveBook(Book book) {
        if (!isBookExist(book)) {
            BooksDTO booksDTO = convertToEntity(book);
            BooksDTO savedBook = booksRepository.save(booksDTO);
            convertToDTO(savedBook);
        }
    }

    @Override
    public void editBook(Integer bookId, Book book) {
        BooksDTO editedBook = booksRepository.findById(bookId).orElseThrow(() -> new IllegalArgumentException("Invalid book id " + bookId));
        if (editedBook != null) {
            saveBook(book);
        }
    }

    @Override
    public void deleteBook(Integer bookId) {
        booksRepository.deleteById(bookId);
    }

    private BooksDTO convertToEntity(Book book) {
        BooksDTO booksDTO = new BooksDTO();
        booksDTO.setTitle(book.title());
        booksDTO.setAuthor(book.author());
        booksDTO.setIsbn(book.isbn());
        booksDTO.setPublicationDate(book.publicationDate());
        booksDTO.setDescription(book.description());
        return booksDTO;
    }

    private boolean isBookExist(Book book) {
        List<Book> books =  getAllBooks();
        for (Book existedBook : books) {
            if (book.isbn().equals((existedBook.isbn()))) {
                return true;
            }
        }
        return false;
    }

    // conversion de BooksDTO to Book(DTO)
    private Book convertToDTO(BooksDTO booksDTO) {
        return new Book(booksDTO.getId(), booksDTO.getTitle(), booksDTO.getAuthor(), booksDTO.getPublicationDate(), booksDTO.getIsbn(), booksDTO.getDescription());
    }
}
