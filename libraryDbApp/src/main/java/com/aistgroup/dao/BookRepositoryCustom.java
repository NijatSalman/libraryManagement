package com.aistgroup.dao;

import com.aistgroup.entity.Book;

import java.util.List;

public interface BookRepositoryCustom {

        public List<Book> getAll();

        public Book getById(int id);

        public boolean addBook(Book book);

        public boolean updateBook(Book book);

        public boolean visibleBook(Book book);

        public boolean removeBook(int id);

}
