package com.aistgroup.dao;

import com.aistgroup.entity.GroupRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRoleRepository extends JpaRepository<GroupRole,Integer>,GroupRoleRepositoryCustom {
}
