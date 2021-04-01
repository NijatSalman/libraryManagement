package com.aistgroup.service.inter;

import com.aistgroup.entity.Book;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookServiceInter {

    public List<Book> getAll();

    public Book getById(int id);

    public boolean addBook(Book book);

    public boolean updateBook(Book book);

    public boolean visibleBook(Book book);

    public boolean removeBook(int id);

    public List<Book> getByPartOfName(@Param("name") String username);

}
