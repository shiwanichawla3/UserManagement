package com.nccp.usermanagement.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nccp.usermanagement.dao.StudentDao;
import com.nccp.usermanagement.entity.Course;
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

	@Override
	public String loginStudent(String email, String password) {
		Student student = studentDao.findStudentByEmailAndPassword(email, password);
		return  student != null ? Integer.toString(student.getStudentId()) : "";
	}

	@Override
	public Set<Course> getEnrolledCourses(String studentId) {
		return studentDao.findCoursesByStudent(studentId);
	}

}
