package com.main.service;

import java.util.List;

import com.main.dto.LoginRequest;
import com.main.model.UserDeials;

public interface UserService {

	public String loginUser(LoginRequest loginRequest);
	
	public List<UserDeials> getAll();
}
