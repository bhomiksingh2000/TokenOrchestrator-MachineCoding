package com.machineCoding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.machineCoding.repository.TokenRepository;
import com.machineCoding.service.TokenService;

@SpringBootApplication
public class InterviewApplication {

	public static void main(String[] args) {
		SpringApplication.run(InterviewApplication.class, args);
	}


	@Bean
	public TokenService tokenService(){
		return new TokenService(new TokenRepository());
	}

}
