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

    // conversion de BooksDTO to Book(DTO)
    private Book convertToDTO(BooksDTO booksDTO) {
        return new Book(booksDTO.getId(), booksDTO.getTitle(), booksDTO.getAuthor(), booksDTO.getPublicationDate(), booksDTO.getIsbn(), booksDTO.getDescription());
    }
}
