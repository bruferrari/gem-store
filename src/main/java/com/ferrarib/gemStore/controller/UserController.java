package com.ferrarib.gemStore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ferrarib.gemStore.log.UserService;
import com.ferrarib.gemStore.model.User;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService service;

	@RequestMapping(method=RequestMethod.GET, produces="application/json")
	public List<User> list() {
		return service.list();
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<?> add(@RequestBody User user) {
		service.addOrUpdate(user);
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setLocation(ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{email}")
				.buildAndExpand(user.getEmail()).toUri());
		
		return new ResponseEntity<>(null, httpHeaders, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{email}", method=RequestMethod.DELETE)
	public ResponseEntity<?> remove(@PathVariable("email") String email) {
		if(!email.isEmpty()) {
			service.remove(email);
			return new ResponseEntity<>(HttpStatus.OK);
		}
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
}
