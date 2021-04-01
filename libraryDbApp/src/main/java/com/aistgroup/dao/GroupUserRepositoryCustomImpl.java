package com.aistgroup.dao;

import com.aistgroup.entity.GroupMember;
import com.aistgroup.entity.GroupUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository("groupUserRepositoryCustomImpl")
public class GroupUserRepositoryCustomImpl implements GroupUserRepositoryCustom{

    @PersistenceContext
    EntityManager em;

    @Override
    public GroupUser getById(int id) {
        GroupUser gu=em.find(GroupUser.class,id);
        return gu;
    }

    @Override
    public List<GroupUser> getAllGroupByUserId(Integer userId) {

        Query query= em.createNativeQuery("Select * from group_user where user_id=?", GroupUser.class);
        //em.find(GroupMember.class,userId);
        query.setParameter(1, userId);

        return query.getResultList();
    }

    @Override
    public List<GroupUser> getAllUserByGroupId(int groupId) {
        Query query= em.createNativeQuery("Select * from group_user where group_id=?",GroupUser.class);
        query.setParameter(1, groupId);

        return query.getResultList();
    }

    @Override
    public boolean insertGroupUser(GroupUser obj) {
        em.persist(obj);
        return true;
    }

    @Override
    public boolean updateGroupUser(GroupUser obj) {
        em.merge(obj);
        return true;
    }

    @Override
    public boolean visibleGroupUser(GroupUser obj) {
        em.merge(obj);
        return true;
    }

    @Override
    public boolean removeGroupUser(int userId) {
        GroupUser gu=em.find(GroupUser.class,userId);
        em.remove(gu);
        return true;
    }
}
