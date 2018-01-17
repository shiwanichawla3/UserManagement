package com.nccp.usermanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nccp.usermanagement.dao.UserDao;
import com.nccp.usermanagement.entity.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

	@Override
	public User getUserById(int userId) {
		return userDao.getUserById(userId);
	}

	@Override
	public synchronized boolean addUser(User user) {
		if (userDao.userExists(user.getUsername())) {
			return false;
		} else {
			userDao.addUser(user);
			return true;
		}
	}

}
