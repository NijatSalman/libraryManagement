package com.aistgroup.dao;
import com.aistgroup.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer>,UserRepositoryCustom {
}
