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

	@SuppressWarnings("unchecked")
	@Override
	public String saveStudent(Student student) {
		List<Student> existingStudent = entityManager.createQuery(FIND_STUDENT_BY_EMAIL).setParameter(1, student.getEmail()).getResultList();
		if (!existingStudent.isEmpty() && existingStudent.get(0)!=null) {
			return "";
		} else {
			try {
				entityManager.persist(student);
			} catch (Exception ex) {
				return "";
			}
		}
		entityManager.flush();
		return Integer.toString(student.getStudentId());
	}

	@Override
	public Student findStudentByEmail(String email) {

		TypedQuery<Student> query = entityManager.createNamedQuery("getStudentByEmail", Student.class);
		query.setParameter("email", email);
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
