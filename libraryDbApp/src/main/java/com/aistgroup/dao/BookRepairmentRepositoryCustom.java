package com.aistgroup.dao;

import com.aistgroup.entity.BookRepairment;
import com.aistgroup.entity.BookReservation;

import java.util.List;

public interface BookRepairmentRepositoryCustom {

        public List<BookRepairment> getAll();

        public BookRepairment getBookRepairmentById(int id);

        public List<BookRepairment> getBookRepairmentByAdminId(int id);

        public List<BookRepairment> getBookRepairmentByBookId(int id);

        public boolean addBookRepairment(BookRepairment bookRepairment);

        public boolean updateBookRepairment(BookRepairment bookRepairment);

        public boolean visibleBookRepairment(BookRepairment bookRepairment);

        public boolean removeBookRepairment(int id);

}
