package com.aistgroup.dao;

import com.aistgroup.entity.BookReservation;

import java.util.List;

public interface BookReservationRepositoryCustom {

        public List<BookReservation> getAll();

        public BookReservation getBookReservationById(int id);

        public List<BookReservation> getBookReservationByUserId(int id);

        public List<BookReservation> getBookReservationByBookId(int id);

        public boolean addBookReservation(BookReservation bookReservation);

        public boolean updateBookReservation(BookReservation bookReservation);

        public boolean visibleBookReservation(BookReservation bookReservation);

        public boolean removeBookReservation(int id);
}
