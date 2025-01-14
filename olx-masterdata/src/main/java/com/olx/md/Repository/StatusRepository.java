package com.olx.md.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.olx.md.entity.StatusEntity;

public interface StatusRepository extends JpaRepository<StatusEntity, Integer>{

}
