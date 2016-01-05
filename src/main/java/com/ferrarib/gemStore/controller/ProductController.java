package com.ferrarib.gemStore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ferrarib.gemStore.model.Product;
import com.ferrarib.gemStore.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	@Autowired
	private ProductService service;

	@RequestMapping(method=RequestMethod.GET, produces="application/json")
	@Cacheable(value="homeProducts")
	public List<Product> list() {
		return service.list();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET, produces="application/json")
	public Product getById(@PathVariable("id") Long id) {
		return service.getById(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	@CacheEvict(value="homeProducts", allEntries=true)
	public ResponseEntity<?> add(@RequestBody Product product) {
		service.add(product);
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setLocation(ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{id}")
				.buildAndExpand(product.getId()).toUri());
		
		return new ResponseEntity<>(null, httpHeaders, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<?> remove(@PathVariable("id") Long id) {
		service.remove(id);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT, consumes="application/json")
	public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody Product product){
		service.update(id, product);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
