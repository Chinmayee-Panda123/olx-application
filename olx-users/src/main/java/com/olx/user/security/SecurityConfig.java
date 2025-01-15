//package com.olx.user.security;
//
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
////import org.springframework.security.authentication.AuthenticationManager;
////import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
////import org.springframework.security.config.Customizer;
////import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
////import org.springframework.security.config.annotation.web.builders.HttpSecurity;
////import org.springframework.security.core.userdetails.User;
////import org.springframework.security.core.userdetails.User.UserBuilder;
////import org.springframework.security.core.userdetails.UserDetails;
////import org.springframework.security.core.userdetails.UserDetailsService;
////import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
////import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
////import org.springframework.security.crypto.password.PasswordEncoder;
////import org.springframework.security.provisioning.InMemoryUserDetailsManager;
////import org.springframework.security.web.SecurityFilterChain;
////import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//@Configuration
//public class SecurityConfig 
//{
//	@Autowired
//	JwtAuthFilter authFilter;
//	
//	@Autowired
//	PasswordEncoder  passwordEncoder;
//	
//	@Autowired
//	UserDetailsService service;
//	
//	
//	@Bean
//	public DaoAuthenticationProvider getAuthenticationProvider()
//	{
//		DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
//		provider.setPasswordEncoder(passwordEncoder);
//		provider.setUserDetailsService(service);
//		return provider;	
//	}
//	
//	public AuthenticationManager getAuthenticationManager(AuthenticationConfiguration config) throws Exception
//	{
//		return config.getAuthenticationManager();
//	}
//		
//	//	Authorization
//	//	To make authorization public
//	//	making csrf disable beuz if not,it will not allow third party to access the http request
//	
//	@Bean
//	public SecurityFilterChain authorize(HttpSecurity httpSecurity)throws Exception
//	{
//		httpSecurity.csrf(csrf->csrf.disable()).authorizeHttpRequests(auth->{
//			auth
////		.requestMatchers("/crud/").hasAnyRole("ADMIN","MANAGER","USER")
////		.requestMatchers("/crud/add").hasRole("ADMIN")
//		.requestMatchers("/users/","").permitAll()
//		.anyRequest().authenticated();
//		})
////		Using default login page,we can add our own login page as well
////		by using Thymeleaf{we hadn't made any login page,so using default page provided by spring security}
////		.formLogin(Customizer.withDefaults())
//		.addFilterBefore(authFilter,UsernamePasswordAuthenticationFilter.class);
//		
//		return httpSecurity.build();
//		
//	}
//	
//	
//	
//	
//	
//	
//
//	
//	
////	Configure multiple usernames in memory
////	@Bean
////	public UserDetailsService users() {
////	
////		UserBuilder builder=User.builder();
////		
////		UserDetails tomUser = builder.username("tom")
////		.password(passwordEncoder.encode( "tom123"))
////		.roles("USER")
////		.build();
////		
////		UserDetails jerryUser = builder
////				.username("jerry")
////				.password(passwordEncoder.encode("jerry123"))
////				.roles("ADMIN")
////				.build();
////		
////		InMemoryUserDetailsManager inMemoryUsers= new InMemoryUserDetailsManager
////				(tomUser,jerryUser);
////		
////		return inMemoryUsers;
////	}
//	
//	
//}
