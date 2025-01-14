package com.olx.md.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.olx.md.entity.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer>{

}
