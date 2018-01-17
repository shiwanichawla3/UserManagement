package com.nccp.usermanagement.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.nccp.usermanagement.dao.StudentDao;
import com.nccp.usermanagement.entity.Course;
import com.nccp.usermanagement.entity.Student;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao studentDao;

	@Autowired
	private PasswordEncoder passwordEncoder;

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

		return true/* studentDao.saveStudent(student) */;

	}

	@Override
	public String loginStudent(String email, String password) {
		Student student = studentDao.findStudentByEmail(email);
		if (student != null && passwordEncoder.matches(password, student.getPassword())) {
			return Integer.toString(student.getStudentId());
		} else {
			return "";
		}
	}

	@Override
	public Set<Course> getEnrolledCourses(String studentId) {
		return studentDao.findCoursesByStudent(studentId);
	}

	@Override
	public String registerStudent(String email, String name, String password) {
		Student student = new Student();
		student.setEmail(email);
		student.setName(name);
		student.setPassword(passwordEncoder.encode(password));
		return studentDao.saveStudent(student);
	}

}
