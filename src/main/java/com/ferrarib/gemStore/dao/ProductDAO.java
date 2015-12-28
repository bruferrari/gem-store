package com.ferrarib.gemStore.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ferrarib.gemStore.model.Product;

@Repository
@Transactional
public class ProductDAO {

	@PersistenceContext
	private EntityManager manager;
	
	public List<Product> list() {
		return manager.createQuery("select p from Product p", Product.class).getResultList();
	}
	
	public Product getById(Long id) {
		return manager.find(Product.class, id);
	}
	
	public void addOrUpdate(Product product) {
		manager.merge(product);
	}
	
	public void remove(Product product) {
		manager.remove(manager.contains(product) ? product : manager.merge(product));
	}
	
}
