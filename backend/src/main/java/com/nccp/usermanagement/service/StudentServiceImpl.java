package com.nccp.usermanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nccp.usermanagement.dao.StudentDao;
import com.nccp.usermanagement.entity.Student;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao studentDao;

	/*
	 * @Autowired private BCryptPasswordEncoder bCryptPasswordEncoder;
	 */
	@Override
	public Student getStudentByEmail(String email) {
		return studentDao.findByEmail(email);
	}

	@Override
	public boolean saveStudent(Student student) {
		// student.setPassword(bCryptPasswordEncoder.encode(student.getPassword()));
		student.setPassword(student.getPassword());

		return studentDao.saveStudent(student);

	}

	public Boolean loginStudent(String email, String password) {
		return studentDao.findStudentByEmailAndPassword(email, password) != null ? true : false;
	}

}
