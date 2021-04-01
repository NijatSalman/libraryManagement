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
@Table(name = "group_member")
//@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "GroupMember.findAll", query = "SELECT g FROM GroupMember g"),
//    @NamedQuery(name = "GroupMember.findById", query = "SELECT g FROM GroupMember g WHERE g.id = :id"),
//    @NamedQuery(name = "GroupMember.findByName", query = "SELECT g FROM GroupMember g WHERE g.name = :name")})
public class GroupMember implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "groupId")
    private List<GroupRole> groupRoleList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "groupId")
    private List<GroupUser> groupUserList;

    public GroupMember() {
    }

    public GroupMember(Integer id) {
        this.id = id;
    }

    public GroupMember(Integer id, String name) {
        this.id = id;
        this.name = name;
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

    @XmlTransient
    public List<GroupRole> getGroupRoleList() {
        return groupRoleList;
    }

    public void setGroupRoleList(List<GroupRole> groupRoleList) {
        this.groupRoleList = groupRoleList;
    }

    @XmlTransient
    public List<GroupUser> getGroupUserList() {
        return groupUserList;
    }

    public void setGroupUserList(List<GroupUser> groupUserList) {
        this.groupUserList = groupUserList;
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
        if (!(object instanceof GroupMember)) {
            return false;
        }
        GroupMember other = (GroupMember) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aistgroup.entity.GroupMember[ id=" + id + " ]";
    }
    
}
