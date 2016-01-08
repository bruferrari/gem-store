package com.ferrarib.gemStore.service;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.ferrarib.gemStore.model.User;

@Component
public class UserLogger {

	final static Logger logger = Logger.getLogger(UserLogger.class);
	
	public void loggingIn(User user) {
		logger.info("logging user: " + user.getEmail());
		user.getRoles().forEach(r -> logger.info("with roles: " + r.getName()));
	}
}
