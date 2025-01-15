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
		UserEntity user = modelMapper.map(userDto, UserEntity.class);
		
		// Set default value for 'active' 
		if (user.getActive() == null) { 
			user.setActive(ActiveStatus.TRUE);  
			} 
		// Set default value for 'roles' 
		if (user.getRoles() == null || user.getRoles().isEmpty()) { 
			user.setRoles("USER"); 
		}
		
		userRepo.save(user);
		return modelMapper.map(user, UserDto.class);
	}
}
