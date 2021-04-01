package com.aistgroup.dao;

import com.aistgroup.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Integer>,BookRepositoryCustom {

    @Query("SELECT b FROM Book b WHERE b.name LIKE CONCAT('%',:name,'%')")
    List<Book> getByPartOfName(@Param("name") String username);

}
