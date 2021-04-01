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
@Table(name = "admin_user_action")
//@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "AdminUserAction.findAll", query = "SELECT a FROM AdminUserAction a"),
//    @NamedQuery(name = "AdminUserAction.findById", query = "SELECT a FROM AdminUserAction a WHERE a.id = :id"),
//    @NamedQuery(name = "AdminUserAction.findByTakenDate", query = "SELECT a FROM AdminUserAction a WHERE a.takenDate = :takenDate"),
//    @NamedQuery(name = "AdminUserAction.findByReceivedDate", query = "SELECT a FROM AdminUserAction a WHERE a.receivedDate = :receivedDate"),
//    @NamedQuery(name = "AdminUserAction.findByVisible", query = "SELECT a FROM AdminUserAction a WHERE a.visible = :visible")})
public class AdminUserAction implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "taken_date")
    @Temporal(TemporalType.DATE)
    private Date takenDate;
    @Column(name = "received_date")
    @Temporal(TemporalType.DATE)
    private Date receivedDate;
    @Basic(optional = false)
    @Column(name = "visible")
    private short visible;
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Book bookId;
    @JoinColumn(name = "admin_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private com.aistgroup.entity.User adminId;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private com.aistgroup.entity.User userId;

    public AdminUserAction() {
    }

    public AdminUserAction(Integer id) {
        this.id = id;
    }

    public AdminUserAction(Integer id, short visible) {
        this.id = id;
        this.visible = visible;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public com.aistgroup.entity.User getAdminId() {
        return adminId;
    }

    public void setAdminId(com.aistgroup.entity.User adminId) {
        this.adminId = adminId;
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
        if (!(object instanceof AdminUserAction)) {
            return false;
        }
        AdminUserAction other = (AdminUserAction) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aistgroup.entity.AdminUserAction[ id=" + id + " ]";
    }
    
}
