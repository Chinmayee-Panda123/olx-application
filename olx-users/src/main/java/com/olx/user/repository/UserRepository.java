package com.olx.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.olx.user.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer>{

}
