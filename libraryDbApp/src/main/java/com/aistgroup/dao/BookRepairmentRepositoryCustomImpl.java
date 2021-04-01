package com.aistgroup.dao;

import com.aistgroup.entity.BookRepairment;
import com.aistgroup.entity.BookReservation;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository("bookRepairmentRepositoryCustomImpl")
public class BookRepairmentRepositoryCustomImpl implements BookRepairmentRepositoryCustom{

    @PersistenceContext
    private EntityManager em;


    @Override
    public List<BookRepairment> getAll() {
        Query query=em.createQuery("Select br from BookRepairment br",BookRepairment.class);
        List<BookRepairment> list=query.getResultList();
        return list;
    }

    @Override
    public BookRepairment getBookRepairmentById(int id) {
        BookRepairment br=em.find(BookRepairment.class,id);
        return br;
    }

    @Override
    public List<BookRepairment> getBookRepairmentByAdminId(int id) {
        Query query=em.createQuery("select br from BookRepairment br where br.adminId=:id",BookRepairment.class);
        query.setParameter("id",id);

        List<BookRepairment> list=query.getResultList();
        return list;
    }

    @Override
    public List<BookRepairment> getBookRepairmentByBookId(int id) {
        Query query=em.createQuery("select br from BookRepairment br where br.bookId=:id",BookRepairment.class);
        query.setParameter("id",id);

        List<BookRepairment> list=query.getResultList();
        return list;
    }

    @Override
    public boolean addBookRepairment(BookRepairment bookRepairment) {
        em.persist(bookRepairment);
        return true;
    }

    @Override
    public boolean updateBookRepairment(BookRepairment bookRepairment) {
        em.merge(bookRepairment);
        return true;
    }

    @Override
    public boolean visibleBookRepairment(BookRepairment bookRepairment) {
        em.merge(bookRepairment);
        return true;
    }

    @Override
    public boolean removeBookRepairment(int id) {
        BookRepairment br=em.find(BookRepairment.class,id);
        em.remove(br);
        return true;
    }
}
