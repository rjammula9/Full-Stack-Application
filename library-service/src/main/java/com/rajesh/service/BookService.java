package com.rajesh.service;

import java.util.List;

import com.rajesh.model.Book;



public interface BookService {
    List<Book> getAllBooks();
    Book getBookById(Long id);
    boolean addBook(Book book);
    boolean updateBook(Long id, Book book);
    boolean deleteBook(Long id);
}
