package com.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.main.dto.LoginRequest;
import com.main.service.UserService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class HomeController {

	@Autowired
	private UserService userService;

	@GetMapping("/")
	public ResponseEntity<?> getDetails(HttpServletRequest httpServletRequest) {
		return new ResponseEntity<>("Hello Welcome", HttpStatus.OK);
	}

	@GetMapping("/all")
	public ResponseEntity<?> geAll(HttpServletRequest httpServletRequest) {
		return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
	}

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {

		String token = userService.loginUser(loginRequest);
		if (token == null) {
			return new ResponseEntity<>("Invalid credential", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(token, HttpStatus.OK);
	}
}
