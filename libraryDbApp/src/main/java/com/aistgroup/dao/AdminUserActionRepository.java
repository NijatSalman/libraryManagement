package com.aistgroup.dao;

import com.aistgroup.entity.AdminUserAction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminUserActionRepository extends JpaRepository<AdminUserAction,Integer>,AdminUserActionRepositoryCustom {
}
