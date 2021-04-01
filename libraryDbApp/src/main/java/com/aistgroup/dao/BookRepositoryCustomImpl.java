package com.aistgroup.dao;

import com.aistgroup.entity.Book;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


@Repository("bookRepositoryCustomImpl")
public class BookRepositoryCustomImpl implements BookRepositoryCustom{

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Book> getAll() {
        Query query=em.createQuery("Select b from Book b",Book.class);
        List<Book> list=query.getResultList();
        return list;
    }


    @Override
    public Book getById(int id) {
       Book book=em.find(Book.class,id);
       return book;
    }

    @Override
    public boolean addBook(Book book) {
        em.persist(book);
        return true;
    }

    @Override
    public boolean updateBook(Book book) {
        em.merge(book);
        return true;
    }

    @Override
    public boolean visibleBook(Book book) {
        em.merge(book);
        return true;
    }

    @Override
    public boolean removeBook(int id) {
        Book book=em.find(Book.class,id);
        em.remove(book);
        return true;
    }


}
