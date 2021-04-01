package com.aistgroup.dao;

import com.aistgroup.entity.GroupRole;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository("groupRoleRepositoryCustomImpl")
public class GroupRoleRepositoryCustomImpl implements GroupRoleRepositoryCustom{

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<GroupRole> getAllGroupRoleByGroupId(int groupId) {
        Query query=em.createQuery("select gr from GroupRole gr where gr.groupId=:id",GroupRole.class);
        List<GroupRole> list= query.getResultList();
        return list;
    }

    @Override
    public boolean insertGroupRole(GroupRole obj) {
        em.persist(obj);
        return true;
    }

    @Override
    public boolean updateGroupRole(GroupRole obj) {
        em.merge(obj);
        return true;
    }

    @Override
    public boolean visibleGroupRole(GroupRole obj) {
        em.merge(obj);
        return true;
    }

    @Override
    public boolean removeGroupRole(int userId) {
        GroupRole gr=em.find(GroupRole.class,userId);
        em.remove(gr);
        return true;
    }
}
