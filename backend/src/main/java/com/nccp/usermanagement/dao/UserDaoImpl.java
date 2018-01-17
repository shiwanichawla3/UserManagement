package com.nccp.usermanagement.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nccp.usermanagement.entity.User;

@Transactional
@Repository
public class UserDaoImpl implements UserDao {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUsers() {
		String hql = "FROM User as us ORDER BY us.userId";
		return (List<User>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public User getUserById(int userId) {
		return entityManager.find(User.class, userId);
	}

	@Override
	public void addUser(User user) {
		entityManager.persist(user);
	}

	@Override
	public boolean userExists(String username) {
		String hql = "FROM User as us WHERE us.username = ?";
		int count = entityManager.createQuery(hql).setParameter(1, username).getResultList().size();
		return count > 0 ? true : false;
	}

}
