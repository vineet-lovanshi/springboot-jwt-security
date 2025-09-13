package com.main.repository;

import java.beans.JavaBean;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.model.UserDeials;

public interface UserRepository extends JpaRepository<UserDeials, Integer> {

	UserDeials findByUsername(String username);

}
