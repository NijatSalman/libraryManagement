package com.aistgroup.dao;

import com.aistgroup.entity.AdminUserAction;
import com.aistgroup.entity.BookReservation;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository("adminUserActionRepositoryCustomImpl")
public class AdminUserActionRepositoryCustomImpl implements AdminUserActionRepositoryCustom{

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<AdminUserAction> getAll() {
        Query query=em.createQuery("select aua from AdminUserAction aua",AdminUserAction.class);
        List<AdminUserAction> list= query.getResultList();
        return list;
    }

    @Override
    public AdminUserAction getAdminUserActionById(int id) {
        AdminUserAction aua=em.find(AdminUserAction.class,id);
        return aua;
    }

    @Override
    public List<AdminUserAction> getAdminUserActionByUserId(int id) {
        Query query=em.createQuery("select aua from AdminUserAction aua where aua.userId=:id",AdminUserAction.class);
        query.setParameter("id",id);
        List<AdminUserAction> list=query.getResultList();
        return list;
    }

    @Override
    public List<AdminUserAction> getAdminUserActionByBookId(int id) {
        Query query=em.createQuery("select aua from AdminUserAction aua where aua.bookId=:id",AdminUserAction.class);
        query.setParameter("id",id);
        List<AdminUserAction> list=query.getResultList();
        return list;
    }

    @Override
    public List<AdminUserAction> getAdminUserActionByAdminId(int id) {
        Query query=em.createQuery("select aua from AdminUserAction aua where aua.adminId=:id",AdminUserAction.class);
        query.setParameter("id",id);
        List<AdminUserAction> list=query.getResultList();
        return list;
    }

    @Override
    public boolean addAdminUserAction(AdminUserAction adminUserAction) {
        em.persist(adminUserAction);
        return true;
    }

    @Override
    public boolean updateAdminUserAction(AdminUserAction adminUserAction) {
        em.merge(adminUserAction);
        return true;
    }

    @Override
    public boolean visibleAdminUserAction(AdminUserAction adminUserAction) {
        em.merge(adminUserAction);
        return true;
    }

    @Override
    public boolean removeAdminUserAction(int id) {
        AdminUserAction aua=em.find(AdminUserAction.class,id);
        em.remove(aua);
        return true;
    }
}
