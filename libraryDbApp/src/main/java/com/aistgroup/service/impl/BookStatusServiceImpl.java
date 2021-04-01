package com.aistgroup.service.impl;

import com.aistgroup.dao.BookStatusRepository;
import com.aistgroup.entity.BookStatus;
import com.aistgroup.service.inter.BookStatusServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookStatusServiceImpl implements BookStatusServiceInter {

    @Autowired
    private BookStatusRepository bsDao;

    @Override
    public List<BookStatus> getAll() {
        return bsDao.getAll();
    }

    @Override
    public BookStatus getByName(String name) {
        return bsDao.getByName(name);
    }

    @Override
    public BookStatus getById(int id) {
        return bsDao.getById(id);
    }

    @Override
    public boolean addBookStatus(BookStatus bookStatus) {
        return bsDao.addBookStatus(bookStatus);
    }

    @Override
    public boolean updateBookStatus(BookStatus bookStatus) {
        return bsDao.updateBookStatus(bookStatus);
    }

    @Override
    public boolean visibleBookStatus(BookStatus bookStatus) {
        return bsDao.visibleBookStatus(bookStatus);
    }

    @Override
    public boolean removeBookStatus(int id) {
        return bsDao.removeBookStatus(id);
    }
}
