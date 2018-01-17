package com.nccp.usermanagement.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nccp.usermanagement.entity.Course;

@Transactional
@Repository
public class CourseDaoImpl implements CourseDao {

	@PersistenceContext
	private EntityManager entityManager;

	private static final String FIND_COURSE_BY_SUBJECT = "FROM Course as cs WHERE cs.subject = ?";

	@Override
	public Course findBySubject(String subject) {
		return (Course) entityManager.createQuery(FIND_COURSE_BY_SUBJECT).setParameter(1, subject).getResultList()
				.get(0);
	}

}
