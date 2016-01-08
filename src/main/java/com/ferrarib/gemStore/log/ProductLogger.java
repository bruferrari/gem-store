package com.ferrarib.gemStore.log;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class ProductLogger {

	final static Logger logger = Logger.getLogger(ProductLogger.class);
	
	public void listing() {
		logger.info("listing products - SERVICE");
	}
	
	public void gettingById() {
		logger.info("getting products by ID - SERVICE");
	}
	
	public void addingProduct() {
		logger.info("adding product - SERVICE");
	}
	
	public void removingProduct() {
		logger.info("removing product - SERVICE");
	}
	
	public void updatingProduct() {
		logger.info("updating product - SERVICE");
	}
}
