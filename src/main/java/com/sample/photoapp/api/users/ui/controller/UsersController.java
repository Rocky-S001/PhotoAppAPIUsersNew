package com.sample.photoapp.api.users.ui.controller;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.photoapp.api.users.service.UsersService;
import com.sample.photoapp.api.users.shared.UserDto;
import com.sample.photoapp.api.users.ui.model.CreateUserRequestModel;
import com.sample.photoapp.api.users.ui.model.CreateUserResponseModel;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UsersController {

	@Autowired
	private Environment env;

	@Autowired
	UsersService usersService;

	@Autowired
	@GetMapping(path = "/status/check")
	public String status() {
		return "Users Microservice is Working on Port : " + env.getProperty("local.server.port");
	}

	@PostMapping
	public ResponseEntity<CreateUserResponseModel> createUser(@Valid @RequestBody CreateUserRequestModel userDetails) {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

		UserDto userDto = mapper.map(userDetails, UserDto.class);
		UserDto createdUser = usersService.createUser(userDto);

		CreateUserResponseModel response = mapper.map(createdUser, CreateUserResponseModel.class);

		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
}
