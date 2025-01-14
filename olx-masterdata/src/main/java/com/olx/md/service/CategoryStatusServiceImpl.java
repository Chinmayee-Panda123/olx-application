package com.olx.md.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olx.md.Repository.CategoryRepository;
import com.olx.md.Repository.StatusRepository;
import com.olx.md.dto.CategoryDto;
import com.olx.md.dto.StatusDto;
import com.olx.md.entity.CategoryEntity;
import com.olx.md.entity.StatusEntity;




@Service
public class CategoryStatusServiceImpl implements CategoryStatusService {

	@Autowired
	private CategoryRepository cRepo;
	
	@Autowired
	private StatusRepository sRepo;

    @Autowired
    private ModelMapper modelMapper;

    

    @Override
    public List<CategoryDto> getAllCategories() {
        List<CategoryEntity> categories = cRepo.findAll();
        return categories.stream()
                .map((CategoryEntity category) -> modelMapper.map(category, CategoryDto.class)) 
                .collect(Collectors.toList());
    }
    
    
    @Override
    public List<StatusDto> getAllStatuses() {
        List<StatusEntity> statuses = sRepo.findAll(); // Fetch all statuses from DB
        return statuses.stream()
                .map(status -> modelMapper.map(status, StatusDto.class)) // Map to StatusDto using ModelMapper
                .collect(Collectors.toList());
    }
    
    
    
}