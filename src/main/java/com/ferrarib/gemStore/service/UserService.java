package com.ferrarib.gemStore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ferrarib.gemStore.dao.UserDAO;
import com.ferrarib.gemStore.model.User;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserDAO userDao;
	
	public List<User> list() {
		return userDao.list();
	}
	
	public void addOrUpdate(User user) {
		userDao.addOrUpdate(user);
	}
	
	public void remove(String email) {
		userDao.remove(email);
	}
}
