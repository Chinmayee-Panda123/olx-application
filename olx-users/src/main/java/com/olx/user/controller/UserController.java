package com.olx.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.olx.user.dto.UserDto;
import com.olx.user.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping(value="/")
	public ResponseEntity<UserDto> registerUser(@RequestBody UserDto userDto){
		UserDto createdUser = userService.registerUser(userDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
	}
	
}
