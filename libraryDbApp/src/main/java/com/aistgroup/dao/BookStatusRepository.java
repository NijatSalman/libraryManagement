package com.aistgroup.dao;

import com.aistgroup.entity.BookStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookStatusRepository extends JpaRepository<BookStatus,Integer>,BookStatusRepositoryCustom {
}
