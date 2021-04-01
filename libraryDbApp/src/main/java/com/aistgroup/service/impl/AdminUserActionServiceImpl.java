package com.aistgroup.service.impl;

import com.aistgroup.dao.AdminUserActionRepository;
import com.aistgroup.entity.AdminUserAction;
import com.aistgroup.entity.BookReservation;
import com.aistgroup.service.inter.AdminUserActionServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AdminUserActionServiceImpl implements AdminUserActionServiceInter {

    @Autowired
    private AdminUserActionRepository auaDao;

    @Override
    public List<AdminUserAction> getAll() {
        return auaDao.getAll();
    }

    @Override
    public AdminUserAction getAdminUserActionById(int id) {
        return auaDao.getAdminUserActionById(id);
    }

    @Override
    public List<AdminUserAction> getAdminUserActionByUserId(int id) {
        return auaDao.getAdminUserActionByUserId(id);
    }

    @Override
    public List<AdminUserAction> getAdminUserActionByBookId(int id) {
        return auaDao.getAdminUserActionByBookId(id);
    }

    @Override
    public List<AdminUserAction> getAdminUserActionByAdminId(int id) {
        return auaDao.getAdminUserActionByAdminId(id);
    }

    @Override
    public boolean addAdminUserAction(AdminUserAction adminUserAction) {
        return auaDao.addAdminUserAction(adminUserAction);
    }

    @Override
    public boolean updateAdminUserAction(AdminUserAction adminUserAction) {
        return auaDao.updateAdminUserAction(adminUserAction);
    }

    @Override
    public boolean visibleAdminUserAction(AdminUserAction adminUserAction) {
        return auaDao.visibleAdminUserAction(adminUserAction);
    }

    @Override
    public boolean removeAdminUserAction(int id) {
        return auaDao.removeAdminUserAction(id);
    }
}
