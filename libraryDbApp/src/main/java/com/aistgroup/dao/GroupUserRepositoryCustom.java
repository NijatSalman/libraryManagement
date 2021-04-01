package com.aistgroup.dao;

import com.aistgroup.entity.GroupUser;

import java.util.List;

public interface GroupUserRepositoryCustom {

    public GroupUser getById(int id);

    public List<GroupUser> getAllGroupByUserId(Integer userId);

    public List<GroupUser> getAllUserByGroupId(int groupId);

    public boolean insertGroupUser(GroupUser obj);

    public boolean updateGroupUser(GroupUser obj);

    public boolean visibleGroupUser(GroupUser obj);

    public boolean removeGroupUser(int userId);
}
