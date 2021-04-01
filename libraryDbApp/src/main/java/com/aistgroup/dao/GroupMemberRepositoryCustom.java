package com.aistgroup.dao;

import com.aistgroup.entity.Book;
import com.aistgroup.entity.GroupMember;

import java.util.List;

public interface GroupMemberRepositoryCustom {

    public List<GroupMember> getAll();

    public GroupMember getByName(String name);

    public GroupMember getById(int id);

    public boolean addGroupMember(GroupMember groupMember);

    public boolean updateGroupMember(GroupMember groupMember);

    public boolean visibleGroupMember(GroupMember groupMember);

    public boolean removeGroupMember(int id);
}
