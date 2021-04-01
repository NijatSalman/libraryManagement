/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aistgroup.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Nicat
 */
@Entity
@Table(name = "user")
//@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
//    @NamedQuery(name = "User.findById", query = "SELECT u FROM User u WHERE u.id = :id"),
//    @NamedQuery(name = "User.findByName", query = "SELECT u FROM User u WHERE u.name = :name"),
//    @NamedQuery(name = "User.findBySurname", query = "SELECT u FROM User u WHERE u.surname = :surname"),
//    @NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User u WHERE u.email = :email"),
//    @NamedQuery(name = "User.findByPassword", query = "SELECT u FROM User u WHERE u.password = :password")})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "surname")
    private String surname;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "adminId")
    private List<BookRepairment> bookRepairmentList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "adminId")
    private List<AdminUserAction> adminUserActionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private List<AdminUserAction> adminUserActionList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private List<GroupUser> groupUserList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private List<BookReservation> bookReservationList;

    public User() {
    }

    public User(Integer id) {
        this.id = id;
    }

    public User(Integer id, String name, String surname, String email, String password) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    @XmlTransient
    public List<AdminUserAction> getAdminUserActionList1() {
        return adminUserActionList1;
    }

    public void setAdminUserActionList1(List<AdminUserAction> adminUserActionList1) {
        this.adminUserActionList1 = adminUserActionList1;
    }

    @XmlTransient
    public List<GroupUser> getGroupUserList() {
        return groupUserList;
    }

    public void setGroupUserList(List<GroupUser> groupUserList) {
        this.groupUserList = groupUserList;
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
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aistgroup.entity.User[ id=" + id + " ]";
    }
    
}
