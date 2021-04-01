package com.aistgroup.dao;

import com.aistgroup.entity.BookStatus;
import com.aistgroup.entity.Role;

import java.util.List;

public interface RoleRepositoryCustom {

    public List<Role> getAll();

    public Role getByName(String name);

    public Role getById(int id);

    public boolean addRole(Role role);

    public boolean updateRole(Role role);

    public boolean visibleRole(Role role);

    public boolean removeRole(int id);
}
