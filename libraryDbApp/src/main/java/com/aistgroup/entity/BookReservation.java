/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aistgroup.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Nicat
 */
@Entity
@Table(name = "book_reservation")
//@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "BookReservation.findAll", query = "SELECT b FROM BookReservation b"),
//    @NamedQuery(name = "BookReservation.findById", query = "SELECT b FROM BookReservation b WHERE b.id = :id"),
//    @NamedQuery(name = "BookReservation.findByDate", query = "SELECT b FROM BookReservation b WHERE b.date = :date"),
//    @NamedQuery(name = "BookReservation.findByVisible", query = "SELECT b FROM BookReservation b WHERE b.visible = :visible")})
public class BookReservation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @Column(name = "visible")
    private short visible;
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Book bookId;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private com.aistgroup.entity.User userId;

    public BookReservation() {
    }

    public BookReservation(Integer id) {
        this.id = id;
    }

    public BookReservation(Integer id, short visible) {
        this.id = id;
        this.visible = visible;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public short getVisible() {
        return visible;
    }

    public void setVisible(short visible) {
        this.visible = visible;
    }

    public Book getBookId() {
        return bookId;
    }

    public void setBookId(Book bookId) {
        this.bookId = bookId;
    }

    public com.aistgroup.entity.User getUserId() {
        return userId;
    }

    public void setUserId(com.aistgroup.entity.User userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BookReservation)) {
            return false;
        }
        BookReservation other = (BookReservation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aistgroup.entity.BookReservation[ id=" + id + " ]";
    }
    
}
