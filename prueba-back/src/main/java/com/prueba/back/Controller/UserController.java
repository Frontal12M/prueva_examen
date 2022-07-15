package com.prueba.back.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.back.Model.User;
import com.prueba.back.Service.UserService;
import com.prueba.back.utilerias.JSONResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService service;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<JSONResponse> add(@RequestBody User user){
		return service.add(user);
	}
	
	@RequestMapping(value = "/addUserByClientManager", method = RequestMethod.POST)
	public ResponseEntity<JSONResponse> addUserByClientManager(@RequestBody User userAccount) {
		return service.addUserByClientManager(userAccount);
	}
	
	@GetMapping(value = "/login")
	public ResponseEntity<JSONResponse> login(@RequestParam(name = "email") String email,
			@RequestParam(name = "password") String password) {
		log.info("login");
		System.out.println("LOGIN:::::");
		return service.login(email, password);
	}
}
