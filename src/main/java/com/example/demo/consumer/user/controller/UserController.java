package com.example.demo.consumer.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.sdk.user.service.UserSdk;


@RestController
public class UserController {

	@Autowired
	private UserSdk userSdk;
	
	@GetMapping("/test")
	public ResponseEntity<String> probando() {
		
		System.out.println("probando");
		userSdk.findAll();
		System.out.println("termino prueba");
		
		return new ResponseEntity<String>("probando", HttpStatus.OK);
	}

	
}
