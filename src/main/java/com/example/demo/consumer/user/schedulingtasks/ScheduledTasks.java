package com.example.demo.consumer.user.schedulingtasks;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.demo.consumer.user.entity.User;
import com.example.demo.consumer.user.service.UserService;
import com.example.demo.dto.user.UserCreateDto;
import com.example.demo.dto.user.UserDto;
import com.example.demo.sdk.user.service.UserSdk;

@Component
public class ScheduledTasks {

	private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	@Autowired
	private UserSdk userSdk;

	@Autowired
	private UserService userService;

	// @Scheduled(fixedRate = 5000)
	public void getUserFromTheService() {
		log.info("get Users From The Service with SDK {}", dateFormat.format(new Date()));
		List<UserDto> users = userSdk.getAll();
		users.forEach(user -> log.info(user.toString()));
	}

	// @Scheduled(fixedRate = 5000)
	public void getUserByIdFromTheService() {
		log.info("get User by id From The Service with SDK {}", dateFormat.format(new Date()));
		UserDto user = userSdk.get("5f0213b863993b271b08a54b");
		log.info(user.toString());
	}

	@Scheduled(fixedRate = 5000)
	public void deleteUsersFromTheService() {
		log.info("delete Users From The Service with SDK {}", dateFormat.format(new Date()));
		List<UserDto> users = userSdk.getAll();
		users.forEach(user -> userSdk.delete(user.getId()));
	}

	// @Scheduled(fixedRate = 5000)
	public void uploadUsersToTheService() {
		log.info("upload Users To The Service with SDK {}", dateFormat.format(new Date()));
		List<User> users = userService.getUsers();

		for (User user : users) {
			UserCreateDto userCreateDto = new UserCreateDto();
			userCreateDto.setName(user.getName());
			userCreateDto.setSurname(user.getSurname());
			userCreateDto.setUsername(user.getUsername());
			userCreateDto.setPassword(user.getPassword());
			userCreateDto.setRoles(Arrays.asList(user.getRole()));
			UserDto userCreated = userSdk.add(userCreateDto);
			log.info(userCreated.toString());
		}
	}

}