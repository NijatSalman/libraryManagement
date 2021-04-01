package com.aistgroup.dao;

import com.aistgroup.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Integer>,RoleRepositoryCustom {
}
