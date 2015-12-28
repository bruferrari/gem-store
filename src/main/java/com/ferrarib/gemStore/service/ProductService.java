package com.ferrarib.gemStore.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ferrarib.gemStore.dao.ProductDAO;
import com.ferrarib.gemStore.model.Product;

@Service
public class ProductService {
	
	final static Logger logger = Logger.getLogger(ProductService.class);
	
	@Autowired
	private ProductDAO prodDao;

	public List<Product> list() {
		logger.info("list - SERVICE");
		return prodDao.list();
	}
	
	public Product getById(Long id) {
		logger.info("getById - SERVICE");
		return prodDao.getById(id);
	}
	
	public void add(Product product) {
		logger.info("add - SERVICE");
		prodDao.addOrUpdate(product);
	}
	
	public void remove(Long id) {
		logger.info("remove - SERVICE");
		Product product = prodDao.getById(id);
		
		if(product != null) {
			prodDao.remove(product);
		}
	}
	
	public void update(Long id, Product modified) {
		logger.info("update - SERVICE");
		Product product = prodDao.getById(id);
		
		if(product != null) {
			product = modified;
			prodDao.addOrUpdate(product);
		}
	}
}
