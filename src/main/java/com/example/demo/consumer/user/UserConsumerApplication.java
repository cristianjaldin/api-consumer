package com.example.demo.consumer.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class UserConsumerApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(UserConsumerApplication.class, args);
		
	}

}
