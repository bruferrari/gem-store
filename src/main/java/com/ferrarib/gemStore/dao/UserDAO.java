package com.ferrarib.gemStore.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.ferrarib.gemStore.model.Role;
import com.ferrarib.gemStore.model.User;

@Repository
public class UserDAO implements UserDetailsService {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = manager.createQuery("select u from User u where u.email = :email", User.class)
				.setParameter("email", email).getSingleResult();
		
		if(user == null) {
			throw new UsernameNotFoundException("User with email " + email + " not found.");
		}
		System.out.println("user: " + user.getEmail());
		
		System.out.println("roles: ");
		user.getRoles().forEach(r -> System.out.println(r.getName()));
		return user;
	}
	
	public List<User> list() {
		return manager.createQuery("select u from User u", User.class).getResultList();
	}
	
	public void addOrUpdate(User user) {
		manager.merge(user);
	}
	
	public User getByEmail(String email) {
		return manager.createQuery("select u from User u where u.email like :email", User.class)
				.setParameter("email", email + "%")
				.getSingleResult();
	}
	
	public void remove(String email) {
		User user = getByEmail(email);
		manager.remove(user);
	}
}
