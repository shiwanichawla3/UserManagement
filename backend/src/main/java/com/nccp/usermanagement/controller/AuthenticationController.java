package com.nccp.usermanagement.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nccp.usermanagement.annotation.LogExecutionTime;
import com.nccp.usermanagement.form.LoginForm;
import com.nccp.usermanagement.service.StudentService;

@RestController
@RequestMapping("/api")
public class AuthenticationController {
	private static final Log LOG = LogFactory.getLog(AuthenticationController.class);

	@Autowired
	private StudentService studentService;

	@LogExecutionTime
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<String> login(@RequestBody LoginForm loginForm) {
		LOG.info("Login request");
		return new ResponseEntity<String>(studentService.loginStudent(loginForm.getEmail(), loginForm.getPassword()),
				HttpStatus.OK);
	}
}