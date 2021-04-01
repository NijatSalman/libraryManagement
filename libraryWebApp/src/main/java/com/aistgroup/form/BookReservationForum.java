package com.aistgroup.form;


import java.sql.Date;

public class BookReservationForum {
    private Integer id;
    private Integer userId;
    private Integer bookId;
    private Date date;

    public BookReservationForum() {
    }

    public BookReservationForum(Integer id, Integer userId, Integer bookId, Date date) {
        this.id = id;
        this.userId = userId;
        this.bookId = bookId;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
