package com.olx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.olx.dto.AdvertiseDto;
import com.olx.service.AdvertiseService;

@RestController
@RequestMapping(value="/add")
public class AdvertiseController {

	@Autowired
	private AdvertiseService addService;
	
	// Posts new advertise - authorization needed
	@PostMapping(value="/create")
	public ResponseEntity<AdvertiseDto> createAdvertise(@RequestBody AdvertiseDto advertiseDto){
		AdvertiseDto addDto = addService.createAdvertise(advertiseDto);
		return new ResponseEntity<>(addDto, HttpStatus.CREATED);
	} 
	
	// Updates existing advertise - authorization needed
	@PutMapping(value="/{id}")
	public ResponseEntity<?> updateAdvertise(@PathVariable int id, @RequestBody AdvertiseDto advertiseDto) {
	    AdvertiseDto updatedDto = addService.updateAdvertise(id, advertiseDto);
	    return new ResponseEntity<>(updatedDto, HttpStatus.OK);
	}
	
	//Reads all advertisements posted by logged in user - authorization needed
	@GetMapping(value="/")
	public ResponseEntity<List<?>> getAllAdvertise(){
		List<AdvertiseDto> adds = addService.getAllAdvertise();
		return new ResponseEntity<>(adds, HttpStatus.OK);
	}
	
	//Reads specific advertisement posed by logged in user (id) - authorization needed
	@GetMapping(value="/{id}")
	public ResponseEntity<?> getAdvertiseById(@PathVariable int id){
		AdvertiseDto add = addService.getAdvertiseById(id);
		return new ResponseEntity<>(add, HttpStatus.OK);
	}

	//Deletes specific advertisement posted by logged in user - authorization needed
	@DeleteMapping(value="/delete/{id}")
	public ResponseEntity<Boolean> deleteById(@PathVariable int id){
		return new ResponseEntity<>(addService.deleteById(id), HttpStatus.OK);
	}
	
//	// 13 filterCriateria
//	@GetMapping(value="/search/")
//	public ResponseEntity<List<AdvertiseDto>> searchAddByFilter(
//	        @RequestParam (required=false) String searchText,
//	        @RequestParam (name = "title",required=false) String title,
//	        @RequestParam (name = "description",required=false) String description,
////	        @RequestParam (required=false, defaultValue = "0") int category,
//	        @RequestParam (name = "postedBy",required=false) String postedBy,
//	        @RequestParam (name = "sortBy",required=false) String sortBy,
//	        @RequestParam (name = "startIndex",required=false, defaultValue = "0") Integer startIndex,
//	        @RequestParam (name = "records",required=false, defaultValue = "10") Integer records
//	) {
//	    List<AdvertiseDto> results = addService.searchAddByFilter(searchText, title, description, postedBy, sortBy, startIndex, records);
//	    return new ResponseEntity<>(results, HttpStatus.OK);
//	}



	

}
