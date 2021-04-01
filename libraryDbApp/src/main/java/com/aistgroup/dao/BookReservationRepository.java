package com.aistgroup.dao;

import com.aistgroup.entity.BookReservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookReservationRepository extends JpaRepository<BookReservation,Integer>,BookReservationRepositoryCustom {
}
