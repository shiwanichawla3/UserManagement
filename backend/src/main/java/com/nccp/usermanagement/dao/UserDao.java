package com.nccp.usermanagement.dao;

import java.util.List;

import com.nccp.usermanagement.entity.User;

public interface UserDao {

	List<User> getAllUsers();

	User getUserById(int userId);

	void addUser(User user);

	boolean userExists(String username);

}
