package com.ferrarib.gemStore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ferrarib.gemStore.dao.ProductDAO;
import com.ferrarib.gemStore.model.Product;

@Service
public class ProductService {

	@Autowired
	private ProductLogger logger;

	@Autowired
	private ProductDAO prodDao;

	public List<Product> list() {
		logger.listing();
		return prodDao.list();
	}

	public Product getById(Long id) {
		logger.gettingById();
		return prodDao.getById(id);
	}

	public void add(Product product) {
		logger.addingProduct();
		prodDao.addOrUpdate(product);
	}

	public void remove(Long id) {
		logger.removingProduct();
		Product product = prodDao.getById(id);

		if (product != null) {
			prodDao.remove(product);
		}
	}

	public void update(Long id, Product modified) {
		logger.updatingProduct();
		Product product = prodDao.getById(id);

		if (product != null) {
			product = modified;
			prodDao.addOrUpdate(product);
		}
	}
}
