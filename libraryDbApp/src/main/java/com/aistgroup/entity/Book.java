/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aistgroup.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Nicat
 */
@Entity
@Table(name = "book")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Book.findAll", query = "SELECT b FROM Book b"),
        @NamedQuery(name = "Book.findById", query = "SELECT b FROM Book b WHERE b.id = :id"),
        @NamedQuery(name = "Book.findByName", query = "SELECT b FROM Book b WHERE b.name = :name"),
        @NamedQuery(name = "Book.findByVisible", query = "SELECT b FROM Book b WHERE b.visible = :visible")})
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Lob
    @Column(name = "about")
    private String about;
    @Basic(optional = false)
    @Column(name = "visible")
    private short visible;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bookId")
    private List<BookRepairment> bookRepairmentList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bookId")
    private List<AdminUserAction> adminUserActionList;
    @JoinColumn(name = "book_status_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private BookStatus bookStatusId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bookId")
    private List<BookReservation> bookReservationList;

    public Book() {
    }

    public Book(Integer id) {
        this.id = id;
    }

    public Book(Integer id, String name, short visible) {
        this.id = id;
        this.name = name;
        this.visible = visible;
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

    public short getVisible() {
        return visible;
    }

    public void setVisible(short visible) {
        this.visible = visible;
    }

    @XmlTransient
    public List<BookRepairment> getBookRepairmentList() {
        return bookRepairmentList;
    }

    public void setBookRepairmentList(List<BookRepairment> bookRepairmentList) {
        this.bookRepairmentList = bookRepairmentList;
    }

    @XmlTransient
    public List<AdminUserAction> getAdminUserActionList() {
        return adminUserActionList;
    }

    public void setAdminUserActionList(List<AdminUserAction> adminUserActionList) {
        this.adminUserActionList = adminUserActionList;
    }

    public BookStatus getBookStatusId() {
        return bookStatusId;
    }

    public void setBookStatusId(BookStatus bookStatusId) {
        this.bookStatusId = bookStatusId;
    }

    @XmlTransient
    public List<BookReservation> getBookReservationList() {
        return bookReservationList;
    }

    public void setBookReservationList(List<BookReservation> bookReservationList) {
        this.bookReservationList = bookReservationList;
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
        if (!(object instanceof Book)) {
            return false;
        }
        Book other = (Book) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aistgroup.entity.Book[ id=" + id + " ]";
    }

}
