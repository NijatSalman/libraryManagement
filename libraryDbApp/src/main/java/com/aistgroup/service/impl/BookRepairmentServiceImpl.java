package com.aistgroup.service.impl;

import com.aistgroup.dao.BookRepairmentRepository;
import com.aistgroup.entity.BookRepairment;
import com.aistgroup.service.inter.BookRepairmentServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookRepairmentServiceImpl implements BookRepairmentServiceInter {

    @Autowired
    private BookRepairmentRepository brDao;

    @Override
    public List<BookRepairment> getAll() {
        return brDao.getAll();
    }

    @Override
    public BookRepairment getBookRepairmentById(int id) {
        return brDao.getBookRepairmentById(id);
    }

    @Override
    public List<BookRepairment> getBookRepairmentByAdminId(int id) {
        return brDao.getBookRepairmentByAdminId(id);
    }

    @Override
    public List<BookRepairment> getBookRepairmentByBookId(int id) {
        return brDao.getBookRepairmentByBookId(id);
    }

    @Override
    public boolean addBookRepairment(BookRepairment bookRepairment) {
        return brDao.addBookRepairment(bookRepairment);
    }

    @Override
    public boolean updateBookRepairment(BookRepairment bookRepairment) {
        return brDao.updateBookRepairment(bookRepairment);
    }

    @Override
    public boolean visibleBookRepairment(BookRepairment bookRepairment) {
        return brDao.visibleBookRepairment(bookRepairment);
    }

    @Override
    public boolean removeBookRepairment(int id) {
        return brDao.removeBookRepairment(id);
    }
}
