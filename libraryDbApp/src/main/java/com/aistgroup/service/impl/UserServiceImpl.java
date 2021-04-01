package com.aistgroup.service.impl;

import com.aistgroup.dao.UserRepository;
import com.aistgroup.entity.User;
import com.aistgroup.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserServiceInter {

    @Autowired
    private UserRepository userDao;

    @Override
    public List<User> getAll() {

        return userDao.getAll();
    }

    @Override
    public User findByEmailAndPassword(String email, String password) {
        return userDao.findByEmailAndPassword(email, password);
    }

    @Override
    public User findByEmail(String email) {
        return userDao.findByEmail(email);
    }

    @Override
    public List<User> getAll(String name, String surname, String email) {
        return userDao.getAll(name, surname, email);
    }

    @Override
    public User getById(int id) {
        return userDao.getById(id);
    }

    @Override
    public boolean addUser(User u) {
        return addUser(u);
    }

    @Override
    public boolean updateUser(User u) {
        return userDao.updateUser(u);
    }

    @Override
    public boolean visibleUser(User u) {
        return userDao.visibleUser(u);
    }

    @Override
    public boolean removeUser(int id) {
        return userDao.removeUser(id);
    }
}
