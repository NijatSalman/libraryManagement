package com.aistgroup.service.impl;

import com.aistgroup.dao.BookRepository;
import com.aistgroup.dao.BookReservationRepository;
import com.aistgroup.entity.BookReservation;
import com.aistgroup.service.inter.BookReservationServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookReservationServiceImpl implements BookReservationServiceInter {

    @Autowired
    private BookReservationRepository brDao;

    @Override
    public List<BookReservation> getAll() {
        return brDao.getAll();
    }

    @Override
    public BookReservation getBookReservationById(int id) {
        return brDao.getBookReservationById(id);
    }

    @Override
    public List<BookReservation> getBookReservationByUserId(int id) {
        return brDao.getBookReservationByUserId(id);
    }

    @Override
    public List<BookReservation> getBookReservationByBookId(int id) {
        return brDao.getBookReservationByBookId(id);
    }

    @Override
    public boolean addBookReservation(BookReservation bookReservation) {
        return brDao.addBookReservation(bookReservation);
    }

    @Override
    public boolean updateBookReservation(BookReservation bookReservation) {
        return brDao.updateBookReservation(bookReservation);
    }

    @Override
    public boolean visibleBookReservation(BookReservation bookReservation) {
        return brDao.visibleBookReservation(bookReservation);
    }

    @Override
    public boolean removeBookReservation(int id) {
        return brDao.removeBookReservation(id);
    }
}
