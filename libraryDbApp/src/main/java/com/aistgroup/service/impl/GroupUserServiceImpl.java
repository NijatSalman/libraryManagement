package com.aistgroup.service.impl;

import com.aistgroup.dao.GroupUserRepository;
import com.aistgroup.entity.GroupUser;
import com.aistgroup.service.inter.GroupUserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GroupUserServiceImpl implements GroupUserServiceInter {

    @Autowired
    private GroupUserRepository grDao;

    @Override
    public GroupUser getById(int id) {
        return grDao.getById(id);
    }

    @Override
    public List<GroupUser> getAllGroupByUserId(int userId) {
        return grDao.getAllGroupByUserId(userId);
    }

    @Override
    public List<GroupUser> getAllUserByGroupId(int groupId) {
        return grDao.getAllUserByGroupId(groupId);
    }

    @Override
    public boolean insertGroupUser(GroupUser obj) {
        return grDao.insertGroupUser(obj);
    }

    @Override
    public boolean updateGroupUser(GroupUser obj) {
        return grDao.updateGroupUser(obj);
    }

    @Override
    public boolean visibleGroupUser(GroupUser obj) {
        return grDao.visibleGroupUser(obj);
    }

    @Override
    public boolean removeGroupUser(int userId) {
        return grDao.removeGroupUser(userId);
    }
}
