package com.nccp.usermanagement.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.nccp.usermanagement.annotation.LogExecutionTime;
import com.nccp.usermanagement.entity.User;
import com.nccp.usermanagement.exception.UserManagementException;
import com.nccp.usermanagement.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

	private static final Log LOG = LogFactory.getLog(UserController.class);

	@Autowired
	private UserService userService;

	@LogExecutionTime
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public ResponseEntity<List<User>> getAllUsers() {
		LOG.info("*********************************** Getting All Users *********************");
		List<User> list = userService.getAllUsers();
		return new ResponseEntity<List<User>>(list, HttpStatus.OK);
	}

	@LogExecutionTime
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public ResponseEntity<Void> addUser(@RequestBody User user, UriComponentsBuilder builder)
			throws UserManagementException {
		LOG.info("*********************************** Adding New User *********************");

		boolean flag = userService.addUser(user);
		if (flag == false) {
			throw new UserManagementException("User already exist. Please try to add new User");
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/user/{id}").buildAndExpand(user.getUserId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
}
