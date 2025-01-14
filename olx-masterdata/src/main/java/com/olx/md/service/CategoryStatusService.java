package com.olx.md.service;

import java.util.List;

import com.olx.md.dto.CategoryDto;
import com.olx.md.dto.StatusDto;

public interface CategoryStatusService  {

	List<CategoryDto> getAllCategories();

	List<StatusDto> getAllStatuses();


}
