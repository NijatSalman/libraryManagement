package com.aistgroup.service.impl;

import com.aistgroup.dao.BookRepository;
import com.aistgroup.entity.Book;
import com.aistgroup.service.inter.BookServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookServiceImpl implements BookServiceInter {

    @Autowired
    private BookRepository bookDao;

    @Override
    public List<Book> getAll() {
        return bookDao.getAll();
    }

    @Override
    public Book getById(int id) {
        return bookDao.getById(id);
    }

    @Override
    public boolean addBook(Book book) {
        return bookDao.addBook(book);
    }

    @Override
    public boolean updateBook(Book book) {
        return bookDao.updateBook(book);
    }

    @Override
    public boolean visibleBook(Book book) {
        return bookDao.visibleBook(book);
    }

    @Override
    public boolean removeBook(int id) {
        return bookDao.removeBook(id);
    }

    @Override
    public List<Book> getByPartOfName(String username) {
        return bookDao.getByPartOfName(username);
    }
}
