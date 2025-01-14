package com.olx.md;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OlxMasterdataApplication {

	public static void main(String[] args) {
		SpringApplication.run(OlxMasterdataApplication.class, args);
		System.out.println("olx-masterdata");
	}
	
	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
    }

}
