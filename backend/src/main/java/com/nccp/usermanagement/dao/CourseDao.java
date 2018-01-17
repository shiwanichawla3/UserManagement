package com.nccp.usermanagement.dao;

import com.nccp.usermanagement.entity.Course;

public interface CourseDao {
	Course findBySubject(String subject);
}
