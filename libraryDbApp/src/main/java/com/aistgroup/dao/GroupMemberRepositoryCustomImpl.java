package com.aistgroup.dao;

import com.aistgroup.entity.GroupMember;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


@Repository("groupMemberRepositoryCustomImpl")
public class GroupMemberRepositoryCustomImpl implements GroupMemberRepositoryCustom{

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<GroupMember> getAll() {
        Query query=em.createQuery("Select grm from GroupMember grm", GroupMember.class);
        List<GroupMember> list=query.getResultList();
        return list;
    }

    @Override
    public GroupMember getByName(String name) {
        Query query=em.createQuery("select grm from GroupMember grm where grm.name=:n",GroupMember.class);
       query.setParameter("n",name);
        List<GroupMember> list=query.getResultList();

        if(list.size()==1){
            return list.get(0);
        }
        return null;
    }

    @Override
    public GroupMember getById(int id) {
        GroupMember grm=em.find(GroupMember.class,id);
        return grm;
    }

    @Override
    public boolean addGroupMember(GroupMember groupMember) {
        em.persist(groupMember);
        return true;
    }

    @Override
    public boolean updateGroupMember(GroupMember groupMember) {
        em.merge(groupMember);
        return true;
    }

    @Override
    public boolean visibleGroupMember(GroupMember groupMember) {
        em.merge(groupMember);
        return true;
    }

    @Override
    public boolean removeGroupMember(int id) {
        GroupMember grm=em.find(GroupMember.class,id);
        em.remove(grm);
        return true;
    }
}
