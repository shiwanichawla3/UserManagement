package com.nccp.usermanagement.controller;

import javax.servlet.ServletException;

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
import com.nccp.usermanagement.entity.Student;
import com.nccp.usermanagement.exception.UserManagementException;
import com.nccp.usermanagement.service.StudentService;

@RestController
@RequestMapping("/api")
public class LoginController {

	private static final Log LOG = LogFactory.getLog(LoginController.class);

	@Autowired
	private StudentService studentService;

	@LogExecutionTime
	@RequestMapping(value = "/student", method = RequestMethod.GET)
	public ResponseEntity<Student> login() {

		Student student = studentService.getStudentByEmail("shivanichawla3@gmail.com");
		LOG.info("Login user" + student.getName());

		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}

	@LogExecutionTime
	@RequestMapping(value = "/student", method = RequestMethod.POST)
	public ResponseEntity<Void> register(@RequestBody Student student, UriComponentsBuilder builder)
			throws ServletException {
		LOG.info("*********************************** Registering new student *********************");

		boolean flag = studentService.saveStudent(student);
		if (flag == false) {
			throw new UserManagementException("Student already exist. Please register with different email address");
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/student/{id}").buildAndExpand(student.getStudentId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
}