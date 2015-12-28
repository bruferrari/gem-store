package com.ferrarib.gemStore.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.ferrarib.gemStore.model.Product;

@Repository
public class CartDAO {

	@PersistenceContext
	private EntityManager manager;
	
	private List<Product> products = new ArrayList<>();
	
	public void add(Product product) {
		products.add(product);
		
		for(Product p : products){
			System.out.println(p.getId() + p.getProdName());
			System.out.println(products.size());
		}
	}
}
