package com.olx.user;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OlxUsersApplication {

	public static void main(String[] args) {
		SpringApplication.run(OlxUsersApplication.class, args);
		System.out.println("olx-user");
	}

	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
    }
	
//	@Bean
//	public PasswordEncoder passwordEncoder() { 
//		return new BCryptPasswordEncoder();
//	}
//	
//	@Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
//        return authenticationConfiguration.getAuthenticationManager();
//    }
}
