package com.ferrarib.gemStore.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class LoginController {

	@RequestMapping(method=RequestMethod.GET)
	public Principal user(Principal user) {
		return user;
	}
}
