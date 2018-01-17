package com.nccp.usermanagement.service;

import com.nccp.usermanagement.entity.Student;

public interface StudentService {

	Student getStudentByEmail(String email);

	boolean saveStudent(Student student);

	Boolean loginStudent(String email, String password);
}
