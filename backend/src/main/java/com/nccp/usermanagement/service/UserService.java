package com.nccp.usermanagement.service;

import java.util.List;

import com.nccp.usermanagement.entity.User;

public interface UserService {

	List<User> getAllUsers();

	User getUserById(int userId);

	boolean addUser(User user);
}
