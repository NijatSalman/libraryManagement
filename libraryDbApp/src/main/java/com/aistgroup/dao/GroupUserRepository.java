package com.aistgroup.dao;

import com.aistgroup.entity.GroupUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupUserRepository extends JpaRepository<GroupUser,Integer>,GroupUserRepositoryCustom {
}
