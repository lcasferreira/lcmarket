package com.lcferreira.market.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcferreira.market.model.Product;
import com.lcferreira.market.model.ShoppingCart;
import com.lcferreira.market.model.ShoppingCartStatus;
import com.lcferreira.market.repositories.ProductRepository;
import com.lcferreira.market.repositories.ShoppingCartRepository;

@Service
public class ShoppingCartService {

	@Autowired
	private ShoppingCartRepository shoppingCartRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	public ShoppingCart createShoppingCart(Long idProduct){
		
		
		Product prodToadd = productRepository.findOne(idProduct);
		
		//Verifies if there is a shopping cart. 
		ShoppingCart shoppingCart = shoppingCartRepository.getShoppingCartByStatus(ShoppingCartStatus.BUYING);
		if(shoppingCart == null){
			shoppingCart = new ShoppingCart();
		}
		
		
		shoppingCart.addProduct(prodToadd);
		
		shoppingCart = shoppingCartRepository.save(shoppingCart);
		
		return shoppingCart;
	}

	public ShoppingCart addProductToCart(Long idProduct, Long idShoppingKart) {
		
		Product prodToadd = productRepository.findOne(idProduct);
		
		ShoppingCart shoppingCart = shoppingCartRepository.findOne(idShoppingKart);
		
		shoppingCart.addProduct(prodToadd);
		
		shoppingCart = shoppingCartRepository.save(shoppingCart);
		
		return shoppingCart;
	}

	public ShoppingCart getShoppingCart(Long idShoppingKart) {
		return shoppingCartRepository.findOne(idShoppingKart);
	}

	public ShoppingCart removeProductToCart(Long idProduct, Long idShoppingKart) {
		
		ShoppingCart shoppingCart = shoppingCartRepository.findOne(idShoppingKart);
		
		shoppingCart.removeProduct(idProduct);
		
		if(shoppingCart.getQtyItemsInKart().equals(0)){
			shoppingCartRepository.delete(shoppingCart.getId());
			return null;
		}
		
		shoppingCart = shoppingCartRepository.save(shoppingCart);
		
		return shoppingCart;
	}

	public ShoppingCart getCurrentShoppingCart() {

		ShoppingCart shoppingCart = shoppingCartRepository.getShoppingCartByStatus(ShoppingCartStatus.BUYING);
		
		return shoppingCart;
	}
}
