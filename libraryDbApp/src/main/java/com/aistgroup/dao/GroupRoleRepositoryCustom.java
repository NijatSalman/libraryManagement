package com.aistgroup.dao;

import com.aistgroup.entity.GroupRole;

import java.util.List;

public interface GroupRoleRepositoryCustom {

    public List<GroupRole> getAllGroupRoleByGroupId(int groupId);

    public boolean insertGroupRole(GroupRole obj);

    public boolean updateGroupRole(GroupRole obj);

    public boolean visibleGroupRole(GroupRole obj);

    public boolean removeGroupRole(int userId);
}
