package com.lcferreira.market.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcferreira.market.model.Product;
import com.lcferreira.market.model.ShoppingCart;
import com.lcferreira.market.repositories.ProductRepository;
import com.lcferreira.market.repositories.ShoppingCartRepository;

@Service
public class ShoppingCartService {

	@Autowired
	private ShoppingCartRepository shoppingCartRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	public ShoppingCart createShoppingCart(Long productId){
		
		Product prodToadd = productRepository.findOne(productId);
		
		ShoppingCart shoppingCart = new ShoppingCart();
		
		shoppingCart.addProduct(prodToadd);
		
		shoppingCart = shoppingCartRepository.save(shoppingCart);
		
		return shoppingCart;
	}
}
