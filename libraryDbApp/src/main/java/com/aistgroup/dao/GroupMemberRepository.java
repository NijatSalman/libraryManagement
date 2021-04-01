package com.aistgroup.dao;

import com.aistgroup.entity.GroupMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupMemberRepository extends JpaRepository<GroupMember,Integer>,GroupMemberRepositoryCustom {
}
