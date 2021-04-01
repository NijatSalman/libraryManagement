package com.aistgroup.dao;

import com.aistgroup.entity.BookStatus;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository("bookStatusRepositoryCustomImpl")
public class BookStatusRepositoryCustomImpl implements BookStatusRepositoryCustom{

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<BookStatus> getAll() {
        Query query=em.createQuery("select bs from BookStatus bs",BookStatus.class);
        List<BookStatus> list=query.getResultList();
        return list;
    }

    @Override
    public BookStatus getByName(String name) {
        Query query=em.createQuery("select bs from BookStatus bs where bs.name=:n",BookStatus.class);
        query.setParameter("n",name);

        List<BookStatus> list=query.getResultList();

        if(list.size()==1){
            return list.get(0);
        }
        return null;
    }

    @Override
    public BookStatus getById(int id) {
        BookStatus bs=em.find(BookStatus.class,id);
        return bs;
    }

    @Override
    public boolean addBookStatus(BookStatus bookStatus) {
        em.persist(bookStatus);
        return true;
    }

    @Override
    public boolean updateBookStatus(BookStatus bookStatus) {
        em.merge(bookStatus);
        return true;
    }

    @Override
    public boolean visibleBookStatus(BookStatus bookStatus) {
        em.merge(bookStatus);
        return true;
    }

    @Override
    public boolean removeBookStatus(int id) {
        BookStatus bs=em.find(BookStatus.class,id);
        em.remove(bs);
        return true;
    }
}
