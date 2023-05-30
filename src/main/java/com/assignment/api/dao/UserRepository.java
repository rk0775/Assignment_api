package com.assignment.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment.api.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Integer> {

	public UserModel findByEmail(String email);

}
