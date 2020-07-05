package com.example.demo.consumer.user.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.user.UserCreateDto;
import com.example.demo.dto.user.UserDto;
import com.example.demo.sdk.user.service.UserSdk;


@RestController
public class UserController {

	@Autowired
	private UserSdk userSdk;
	
	@GetMapping("/test/users")
	public ResponseEntity<List<UserDto>> getAll() {
		
		List<UserDto> users = userSdk.findAll();
		users.forEach(System.out::println);
	
		return new ResponseEntity<List<UserDto>>(users, HttpStatus.OK);
	}


	@GetMapping("/test/add")
	public ResponseEntity<UserDto> add() {
		
		//usuario a ingresar
		UserCreateDto userCreateDto =  new UserCreateDto();
		userCreateDto.setName("Criss");
		userCreateDto.setSurname("Jaldin");
		userCreateDto.setUsername("cjaldin");
		userCreateDto.setPassword("1234");
		userCreateDto.setRoles(Arrays.asList("ADMIN"));

		
		UserDto userCreated = userSdk.add(userCreateDto);
		
		
		System.out.println(userCreated);
		
		return new ResponseEntity<UserDto>(userCreated, HttpStatus.OK);
	}

	
}
