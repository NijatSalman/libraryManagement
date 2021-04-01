package com.aistgroup.service.impl;

import com.aistgroup.dao.GroupRoleRepository;
import com.aistgroup.entity.GroupRole;
import com.aistgroup.service.inter.GroupRoleServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GroupRoleServiceImpl implements GroupRoleServiceInter {

   @Autowired
   private GroupRoleRepository grDao;

    @Override
    public List<GroupRole> getAllGroupRoleByGroupId(int groupId) {
        return grDao.getAllGroupRoleByGroupId(groupId);
    }

    @Override
    public boolean insertGroupRole(GroupRole obj) {
        return grDao.insertGroupRole(obj);
    }

    @Override
    public boolean updateGroupRole(GroupRole obj) {
        return grDao.updateGroupRole(obj);
    }

    @Override
    public boolean visibleGroupRole(GroupRole obj) {
        return grDao.visibleGroupRole(obj);
    }

    @Override
    public boolean removeGroupRole(int userId) {
        return grDao.removeGroupRole(userId);
    }
}
