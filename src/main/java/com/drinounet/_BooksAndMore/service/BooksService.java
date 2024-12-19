package com.drinounet._BooksAndMore.service;

import com.drinounet._BooksAndMore.datas.Book;

import java.util.List;

public interface BooksService {
   List<Book> getAllBooks();
   void saveBook(Book book);
   void editBook(Integer bookId, Book book);
   void deleteBook(Integer bookId);
}
