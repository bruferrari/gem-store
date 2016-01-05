package com.ferrarib.gemStore.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ferrarib.gemStore.model.Product;
import com.ferrarib.gemStore.model.ShoppingCart;
import com.ferrarib.gemStore.model.ShoppingCartItem;

@RestController
@RequestMapping("/api/cart")
public class CartController {
	
	@Autowired
	private ShoppingCart cart;

	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<Void> add(@RequestBody Product product) {
		ShoppingCartItem item = createItem(product);
		cart.add(item);
		
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	private ShoppingCartItem createItem(Product product) {
		ShoppingCartItem item = new ShoppingCartItem();
		item.setProduct(product);
		item.setQuantity(1);
		
		return item;
	}
	
//	@RequestMapping(method=RequestMethod.GET, produces="application/json")
//	public Collection<ShoppingCartItem> cartList() {
//		return cart.getItens();
//	}
	
	@RequestMapping(method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<ShoppingCart> cartList() {
		ShoppingCart shoppingCart = new ShoppingCart();
		shoppingCart.setItens(cart.getItens());
		shoppingCart.setSubTotal(cart.getSubTotal());
		return new ResponseEntity<ShoppingCart>(shoppingCart, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}" ,method=RequestMethod.DELETE)
	public ResponseEntity<?> remove(@PathVariable("id") Long id) {
		cart.remove(id);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
