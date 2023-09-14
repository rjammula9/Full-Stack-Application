package com.rajesh.service;

import com.rajesh.dao.BookDAO;
import com.rajesh.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDAO bookDAO;

    @Override
    public List<Book> getAllBooks() {
        return bookDAO.getAllBooks();
    }

    @Override
    public Book getBookById(Long id) {
        return bookDAO.getBookById(id);
    }

    @Override
    public boolean addBook(Book book) {
        try {
            bookDAO.addBook(book);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateBook(Long id, Book book) {
        try {
            book.setId(id);
            bookDAO.updateBook(book);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteBook(Long id) {
        try {
            bookDAO.deleteBook(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
