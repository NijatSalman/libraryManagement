package com.aistgroup.dao;

import com.aistgroup.entity.Book;
import com.aistgroup.entity.BookStatus;

import java.util.List;

public interface BookStatusRepositoryCustom {

    public List<BookStatus> getAll();

    public BookStatus getByName(String name);

    public BookStatus getById(int id);

    public boolean addBookStatus(BookStatus bookStatus);

    public boolean updateBookStatus(BookStatus bookStatus);

    public boolean visibleBookStatus(BookStatus bookStatus);

    public boolean removeBookStatus(int id);
}
