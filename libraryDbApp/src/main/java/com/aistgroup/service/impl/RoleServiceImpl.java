package com.aistgroup.service.impl;

import com.aistgroup.dao.RoleRepository;
import com.aistgroup.entity.Role;
import com.aistgroup.service.inter.RoleServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleServiceInter {

    @Autowired
    private RoleRepository rDao;

    @Override
    public List<Role> getAll() {
        return rDao.getAll();
    }

    @Override
    public Role getByName(String name) {
        return rDao.getByName(name);
    }

    @Override
    public Role getById(int id) {
        return rDao.getById(id);
    }

    @Override
    public boolean addRole(Role role) {
        return rDao.addRole(role);
    }

    @Override
    public boolean updateRole(Role role) {
        return rDao.updateRole(role);
    }

    @Override
    public boolean visibleRole(Role role) {
        return rDao.visibleRole(role);
    }

    @Override
    public boolean removeRole(int id) {
        return rDao.removeRole(id);
    }
}
