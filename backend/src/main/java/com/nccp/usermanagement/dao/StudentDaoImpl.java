package com.nccp.usermanagement.dao;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nccp.usermanagement.entity.Course;
import com.nccp.usermanagement.entity.Student;

@Transactional
@Repository
public class StudentDaoImpl implements StudentDao {

	@PersistenceContext
	private EntityManager entityManager;

	private static final String FIND_STUDENT_BY_EMAIL = "FROM Student as st WHERE st.email = ?";

	@Override
	public Student findByEmail(String email) {
		return (Student) entityManager.createQuery(FIND_STUDENT_BY_EMAIL).setParameter(1, email).getResultList().get(0);
	}

	@Override
	public boolean saveStudent(Student student) {
		Student existingUser = findByEmail(student.getEmail());
		if (existingUser != null) {
			return false;
		}
		entityManager.persist(student);
		return true;
	}

	@Override
	public Student findStudentByEmailAndPassword(String username, String password) {

		TypedQuery<Student> query = entityManager.createNamedQuery("getUserByEmailPwd", Student.class);
		query.setParameter("email", username);
		query.setParameter("password", password);
		Student student = null;
		List<Student> result = query.getResultList();
		if (result != null && !result.isEmpty()) {
			student = (Student) result.get(0);
		}
		return student;
	}

	@Override
	public Set<Course> findCoursesByStudent(String studentId) {
		Student student = entityManager.find(Student.class, Integer.parseInt(studentId));
		return student.getCourses();
	}

}
