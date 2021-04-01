package com.aistgroup.dao;

import com.aistgroup.entity.BookStatus;
import com.aistgroup.entity.Role;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository("roleRepositoryCustomImpl")
public class RoleRepositoryCustomImpl implements RoleRepositoryCustom{

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Role> getAll() {
        Query query=em.createQuery("select r from Role r", Role.class);
        List<Role> list=query.getResultList();
        return list;
    }

    @Override
    public Role getByName(String name) {
        Query query=em.createQuery("select r from Role r where r.name=:n",Role.class);
        query.setParameter("n",name);

        List<Role> list=query.getResultList();
        if(list.size()==1){
            return list.get(0);
        }
        return null;
    }

    @Override
    public Role getById(int id) {
        Role r=em.find(Role.class,id);
        return r;
    }

    @Override
    public boolean addRole(Role role) {
        em.persist(role);
        return true;
    }

    @Override
    public boolean updateRole(Role role) {
        em.merge(role);
        return true;
    }

    @Override
    public boolean visibleRole(Role role) {
        em.merge(role);
        return true;
    }

    @Override
    public boolean removeRole(int id) {
        Role r=em.find(Role.class,id);
        em.remove(r);
        return true;
    }
}
