package com.olx;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class OlxAdvertisesmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(OlxAdvertisesmentApplication.class, args);
		System.out.println("Hello");
	}

	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
    }
}
