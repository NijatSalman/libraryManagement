/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aistgroup.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 *
 * @author Nicat
 */
@Entity
@Table(name = "group_user")
//@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "GroupUser.findAll", query = "SELECT g FROM GroupUser g"),
//    @NamedQuery(name = "GroupUser.findById", query = "SELECT g FROM GroupUser g WHERE g.id = :id")})
public class GroupUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "group_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private com.aistgroup.entity.GroupMember groupId;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private com.aistgroup.entity.User userId;

    public GroupUser() {
    }

    public GroupUser(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public com.aistgroup.entity.GroupMember getGroupId() {
        return groupId;
    }

    public void setGroupId(com.aistgroup.entity.GroupMember groupId) {
        this.groupId = groupId;
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
        if (!(object instanceof GroupUser)) {
            return false;
        }
        GroupUser other = (GroupUser) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aistgroup.entity.GroupUser[ id=" + id + " ]";
    }
    
}
