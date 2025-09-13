package com.main.serevice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.main.dto.LoginRequest;
import com.main.model.UserDeials;
import com.main.repository.UserRepository;
import com.main.service.UserService;

@Service
public class UserServiceImple implements UserService {

	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public String loginUser(LoginRequest loginRequest) {

		Authentication authenticate = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		if (authenticate.isAuthenticated()) {
//			return "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiYWRtaW4iOnRydWUsImlhdCI6MTUxNjIzOTAyMn0.KMUFsIDTnFmyG3nMiGM6H9FNFUROf3wh7SmqJp-QV30";
			return jwtService.generateToken(loginRequest.getUsername());
		}

		return null;
	}

	@Override
	public List<UserDeials> getAll() {
		List<UserDeials> all = userRepository.findAll();
		return all;
	}

}
