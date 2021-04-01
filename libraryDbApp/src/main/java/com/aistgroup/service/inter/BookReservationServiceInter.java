package com.aistgroup.service.inter;

import com.aistgroup.entity.BookReservation;

import java.util.List;

public interface BookReservationServiceInter {
    public List<BookReservation> getAll();

    public BookReservation getBookReservationById(int id);

    public List<BookReservation> getBookReservationByUserId(int id);

    public List<BookReservation> getBookReservationByBookId(int id);

    public boolean addBookReservation(BookReservation bookReservation);

    public boolean updateBookReservation(BookReservation bookReservation);

    public boolean visibleBookReservation(BookReservation bookReservation);

    public boolean removeBookReservation(int id);
}
