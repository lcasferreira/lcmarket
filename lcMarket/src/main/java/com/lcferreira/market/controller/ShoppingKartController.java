package com.lcferreira.market.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lcferreira.market.model.ShoppingCart;
import com.lcferreira.market.service.ShoppingCartService;

@RestController
public class ShoppingKartController {
	
	@Autowired
	private ShoppingCartService shoppingCartService;

	@RequestMapping(value = "/shoppingKarts/{idShoppingKart}", method = RequestMethod.GET, produces = "application/json")
	public ShoppingCart getShoppingCart( @PathVariable(name="idShoppingKart", required = true) Long idShoppingKart){
		ShoppingCart shopCart = shoppingCartService.getShoppingCart(idShoppingKart);
		return shopCart;
	}
	
	@RequestMapping(value = "/shoppingKarts/current", method = RequestMethod.GET, produces = "application/json")
	public ShoppingCart getCurrentShoppingCart(){
		ShoppingCart shopCart = shoppingCartService.getCurrentShoppingCart();
		return shopCart;
	}
	
	@RequestMapping(value = "/shoppingKarts/{idShoppingKart}/products/{idProduct}", method = RequestMethod.PUT, produces = "application/json")
	public ShoppingCart addProduct( @PathVariable(name="idShoppingKart") Long idShoppingKart,
							@PathVariable(name="idProduct") Long idProduct){
		ShoppingCart shopCart = shoppingCartService.addProductToCart(idProduct, idShoppingKart);
		return shopCart;
	}
	
	@RequestMapping(value = "/shoppingKarts/{idShoppingKart}/products/{idProduct}", method = RequestMethod.DELETE, produces = "application/json")
	public ShoppingCart removeProduct( @PathVariable(name="idShoppingKart") Long idShoppingKart,
							@PathVariable(name="idProduct") Long idProduct){
		ShoppingCart shopCart = shoppingCartService.removeProductToCart(idProduct, idShoppingKart);
		return shopCart;
	}
	
	@RequestMapping(value = "/shoppingKarts/products/{idProduct}", method = RequestMethod.POST, produces = "application/json")
	public ShoppingCart createShoppingCart( @PathVariable(name="idProduct") Long idProduct){
		ShoppingCart newCart = shoppingCartService.createShoppingCart(idProduct);
		return newCart;
	}
}
