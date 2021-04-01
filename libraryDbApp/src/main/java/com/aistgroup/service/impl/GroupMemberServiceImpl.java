package com.aistgroup.service.impl;

import com.aistgroup.dao.GroupMemberRepository;
import com.aistgroup.entity.GroupMember;
import com.aistgroup.service.inter.GroupMemberServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GroupMemberServiceImpl implements GroupMemberServiceInter {

    @Autowired
    private GroupMemberRepository grmDao;

    @Override
    public List<GroupMember> getAll() {
        return grmDao.getAll();
    }

    @Override
    public GroupMember getByName(String name) {
        return grmDao.getByName(name);
    }

    @Override
    public GroupMember getById(int id) {
        return grmDao.getById(id);
    }

    @Override
    public boolean addGroupMember(GroupMember groupMember) {
        return grmDao.addGroupMember(groupMember);
    }

    @Override
    public boolean updateGroupMember(GroupMember groupMember) {
        return grmDao.updateGroupMember(groupMember);
    }

    @Override
    public boolean visibleGroupMember(GroupMember groupMember) {
        return grmDao.visibleGroupMember(groupMember);
    }

    @Override
    public boolean removeGroupMember(int id) {
        return grmDao.removeGroupMember(id);
    }
}
