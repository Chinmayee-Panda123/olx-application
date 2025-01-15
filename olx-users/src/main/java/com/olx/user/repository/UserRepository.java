package com.olx.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.olx.user.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer>{

	List<UserEntity> findByUserName(String username);

}
