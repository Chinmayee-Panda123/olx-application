package com.olx.user.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olx.user.dto.ActiveStatus;
import com.olx.user.dto.UserDto;
import com.olx.user.entity.UserEntity;
import com.olx.user.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepo;
	
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public UserDto registerUser(UserDto userDto) {
		// Validate input
        if (userDto.getUsername() == null || userDto.getUsername().isEmpty()) {
            throw new IllegalArgumentException("Username cannot be null or empty");
        }
        if (userDto.getPassword() == null || userDto.getPassword().isEmpty()) {
            throw new IllegalArgumentException("Password cannot be null or empty");
        }
		UserEntity user = modelMapper.map(userDto, UserEntity.class); 
		if (user.getActive() == null) { 
			user.setActive(ActiveStatus.TRUE);  
			} 
		if (user.getRoles() == null || user.getRoles().isEmpty()) { 
			user.setRoles("USER"); 
		}
		
		UserEntity savedUser = userRepo.save(user);
		return modelMapper.map(savedUser, UserDto.class);
	}
}
