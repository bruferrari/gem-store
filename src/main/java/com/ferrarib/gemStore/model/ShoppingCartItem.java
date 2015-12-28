package com.ferrarib.gemStore.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class ShoppingCartItem implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Product product;
	private Integer quantity;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	public BigDecimal getTotal() {
		return this.product.getPrice().multiply(new BigDecimal(this.quantity));
	}

}
