package com.nccp.usermanagement.dao;

import java.util.Set;

import com.nccp.usermanagement.entity.Course;
import com.nccp.usermanagement.entity.Student;

public interface StudentDao {
	Student findByEmail(String email);

	boolean saveStudent(Student student);

	Student findStudentByEmailAndPassword(String string, String string2);

	Set<Course> findCoursesByStudent(String studentId);
}
