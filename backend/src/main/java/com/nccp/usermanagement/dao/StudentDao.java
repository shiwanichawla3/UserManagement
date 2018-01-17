package com.nccp.usermanagement.dao;

import com.nccp.usermanagement.entity.Student;

public interface StudentDao {
	Student findByEmail(String email);

	boolean saveStudent(Student student);

	Student findStudentByEmailAndPassword(String string, String string2);
}
