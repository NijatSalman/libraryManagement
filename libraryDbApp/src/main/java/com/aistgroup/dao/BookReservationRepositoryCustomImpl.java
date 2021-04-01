package com.aistgroup.dao;

import com.aistgroup.entity.Book;
import com.aistgroup.entity.BookReservation;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository("bookReservationRepositoryCustomImpl")
public class BookReservationRepositoryCustomImpl implements BookReservationRepositoryCustom{

    @PersistenceContext
    private EntityManager em;


    @Override
    public List<BookReservation> getAll() {
        Query query=em.createQuery("select br from BookReservation br",BookReservation.class);
        List<BookReservation> list =query.getResultList();
        return list;
    }

    @Override
    public BookReservation getBookReservationById(int id) {
        BookReservation br=em.find(BookReservation.class,id);
        return br;
    }

    @Override
    public List<BookReservation> getBookReservationByUserId(int id) {
        Query query=em.createNativeQuery("select * from book_reservation where user_id=?",BookReservation.class);
        query.setParameter(1,id);

        List<BookReservation> list= query.getResultList();
        return list;
    }

    @Override
    public List<BookReservation> getBookReservationByBookId(int id) {
        Query query=em.createNativeQuery("select * from book_reservation where book_id=?",BookReservation.class);
        query.setParameter(1,id);

        List<BookReservation> list= query.getResultList();
        return list;
    }

    @Override
    public boolean addBookReservation(BookReservation bookReservation) {
        em.persist(bookReservation);
        return true;
    }

    @Override
    public boolean updateBookReservation(BookReservation bookReservation) {
        em.merge(bookReservation);
        return true;
    }

    @Override
    public boolean visibleBookReservation(BookReservation bookReservation) {
        em.merge(bookReservation);
        return true;
    }

    @Override
    public boolean removeBookReservation(int id) {
        BookReservation br=em.find(BookReservation.class,id);
        em.remove(br);
        return true;
    }
}
