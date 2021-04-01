package com.aistgroup.form;

import java.sql.Date;

public class BookedDetailsForum {
    private Integer id;
    private Integer adminId;
    private Integer userId;
    private Integer bookId;
    private Date takenDate;
    private Date receivedDate;

    public BookedDetailsForum() {
    }

    public BookedDetailsForum(Integer id, Integer adminId, Integer userId, Integer bookId, Date takenDate, Date receivedDate) {
        this.id = id;
        this.adminId = adminId;
        this.userId = userId;
        this.bookId = bookId;
        this.takenDate = takenDate;
        this.receivedDate = receivedDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
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

    public Date getTakenDate() {
        return takenDate;
    }

    public void setTakenDate(Date takenDate) {
        this.takenDate = takenDate;
    }

    public Date getReceivedDate() {
        return receivedDate;
    }

    public void setReceivedDate(Date receivedDate) {
        this.receivedDate = receivedDate;
    }


}
