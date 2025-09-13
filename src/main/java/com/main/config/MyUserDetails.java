package com.main.config;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.main.model.UserDeials;


public class MyUserDetails implements UserDetails {

	private UserDeials userDeials;

	public MyUserDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MyUserDetails(UserDeials userDeials) {
		super();
		this.userDeials = userDeials;
	}

	public UserDeials getUserDeials() {
		return userDeials;
	}

	public void setUserDeials(UserDeials userDeials) {
		this.userDeials = userDeials;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		SimpleGrantedAuthority authority = new SimpleGrantedAuthority("USER");
		return Arrays.asList(authority);
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return userDeials.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return userDeials.getUsername();
	}

}
