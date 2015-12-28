package com.ferrarib.gemStore.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ShoppingCart implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<ShoppingCartItem> itens = new CopyOnWriteArrayList<>();

	private BigDecimal subTotal = BigDecimal.ZERO;

	public void setItens(List<ShoppingCartItem> itens) {
		this.itens = itens;
	}

	public void setSubTotal(BigDecimal subTotal) {
		this.subTotal = subTotal;
	}

	public BigDecimal getSubTotal() {
		return subTotal;
	}

	public List<ShoppingCartItem> getItens() {
		return itens;
	}

	private BigDecimal calculateSubTotal() {
		return itens.stream().map(ShoppingCartItem::getTotal).reduce(BigDecimal.ZERO, BigDecimal::add);
	}

	public void add(ShoppingCartItem cartItem) {
		if (!isExistingItem(cartItem)) {
			itens.add(cartItem);
			this.subTotal = calculateSubTotal();
		}
	}

	private boolean isExistingItem(ShoppingCartItem cartItem) {

		for (ShoppingCartItem item : itens) {
			if (item.getProduct().equals(cartItem.getProduct())) {
				item.setQuantity(item.getQuantity() + 1);
				this.subTotal = calculateSubTotal();
				return true;
			}
		}
		return false;

	}

	public void remove(Long id) {

		for (ShoppingCartItem item : itens) {
			if (item.getProduct().getId() == id) {
				itens.remove(item);
				subTotal = this.subTotal.subtract(item.getTotal());
			}
				
		}
	}

}
