package com.rajesh.dao;

import com.rajesh.model.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDAOImpl implements BookDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public BookDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Book> getAllBooks() {
        Session currentSession = sessionFactory.getCurrentSession();
       List<Book> bb = currentSession.createQuery("FROM Book", Book.class).getResultList();
        System.out.println("dao "+bb);
        return bb;
    }

    @Override
    public Book getBookById(Long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.get(Book.class, id);
    }

    @Override
    public void addBook(Book book) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(book);
    }

    @Override
    public void updateBook(Book book) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.update(book);
    }

    @Override
    public void deleteBook(Long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Book book = currentSession.get(Book.class, id);
        if (book != null) {
            currentSession.delete(book);
        }
    }
}
