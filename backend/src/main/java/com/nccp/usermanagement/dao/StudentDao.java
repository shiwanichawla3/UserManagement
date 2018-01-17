package com.nccp.usermanagement.dao;

import java.util.Set;

import com.nccp.usermanagement.entity.Course;
import com.nccp.usermanagement.entity.Student;

public interface StudentDao {
	Student findByEmail(String email);

	String saveStudent(Student student);

	Student findStudentByEmail(String email);

	Set<Course> findCoursesByStudent(String studentId);
}
