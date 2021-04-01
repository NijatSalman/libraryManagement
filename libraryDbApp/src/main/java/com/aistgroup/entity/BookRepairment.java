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
@Table(name = "book_repairment")
//@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "BookRepairment.findAll", query = "SELECT b FROM BookRepairment b"),
//    @NamedQuery(name = "BookRepairment.findById", query = "SELECT b FROM BookRepairment b WHERE b.id = :id"),
//    @NamedQuery(name = "BookRepairment.findByRepairmentDate", query = "SELECT b FROM BookRepairment b WHERE b.repairmentDate = :repairmentDate"),
//    @NamedQuery(name = "BookRepairment.findByFixedDate", query = "SELECT b FROM BookRepairment b WHERE b.fixedDate = :fixedDate")})
public class BookRepairment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "repairment_date")
    @Temporal(TemporalType.DATE)
    private Date repairmentDate;
    @Column(name = "fixed_date")
    @Temporal(TemporalType.DATE)
    private Date fixedDate;
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Book bookId;
    @JoinColumn(name = "admin_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private com.aistgroup.entity.User adminId;

    public BookRepairment() {
    }

    public BookRepairment(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getRepairmentDate() {
        return repairmentDate;
    }

    public void setRepairmentDate(Date repairmentDate) {
        this.repairmentDate = repairmentDate;
    }

    public Date getFixedDate() {
        return fixedDate;
    }

    public void setFixedDate(Date fixedDate) {
        this.fixedDate = fixedDate;
    }

    public Book getBookId() {
        return bookId;
    }

    public void setBookId(Book bookId) {
        this.bookId = bookId;
    }

    public com.aistgroup.entity.User getAdminId() {
        return adminId;
    }

    public void setAdminId(com.aistgroup.entity.User adminId) {
        this.adminId = adminId;
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
        if (!(object instanceof BookRepairment)) {
            return false;
        }
        BookRepairment other = (BookRepairment) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aistgroup.entity.BookRepairment[ id=" + id + " ]";
    }
    
}
