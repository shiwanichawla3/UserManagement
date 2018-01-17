package com.nccp.usermanagement.service;

import java.util.Set;

import com.nccp.usermanagement.entity.Course;
import com.nccp.usermanagement.entity.Student;

public interface StudentService {

	Student getStudentByEmail(String email);

	boolean saveStudent(Student student);

	String loginStudent(String email, String password);

	Set<Course> getEnrolledCourses(String studentId);
	
	String registerStudent(String email,String name, String password);

}
