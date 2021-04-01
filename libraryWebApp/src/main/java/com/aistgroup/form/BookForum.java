package com.aistgroup.form;

public class BookForum {
    private Integer id;
    private String name;
    private String about;
    private Integer bookStatus;


    public BookForum() {

    }

    public BookForum(Integer id, String name, String about, Integer bookStatus) {
        this.id = id;
        this.name = name;
        this.about = about;
        this.bookStatus = bookStatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public Integer getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(Integer bookStatus) {
        this.bookStatus = bookStatus;
    }
}
