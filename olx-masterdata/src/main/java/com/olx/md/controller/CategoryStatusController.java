package com.olx.md.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.olx.md.dto.CategoryDto;
import com.olx.md.dto.StatusDto;
import com.olx.md.service.CategoryStatusService;

@RestController
@RequestMapping("/cate")
public class CategoryStatusController {

    private final CategoryStatusService csService;

    @Autowired
    public CategoryStatusController(CategoryStatusService csService) {
        this.csService = csService;
    }

    @GetMapping("/category")
    public ResponseEntity<Map<String, List<CategoryDto>>> getAllCategories() {
        List<CategoryDto> categories = csService.getAllCategories();
        Map<String, List<CategoryDto>> response = Map.of("categories", categories);
        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/status")
    public ResponseEntity<Map<String, List<StatusDto>>> getAllStatuses() {
        List<StatusDto> statuses = csService.getAllStatuses(); 
        Map<String, List<StatusDto>> response = Map.of("statusList", statuses);
        return ResponseEntity.ok(response); 
    }
}