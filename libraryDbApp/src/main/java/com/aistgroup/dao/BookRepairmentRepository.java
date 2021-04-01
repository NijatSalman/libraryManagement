package com.aistgroup.dao;

import com.aistgroup.entity.BookRepairment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepairmentRepository extends JpaRepository<BookRepairment,Integer>,BookRepairmentRepositoryCustom {
}
