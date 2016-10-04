package com.lcferreira.market.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShoppingKartController {

	@RequestMapping(value = "/shoppingKarts/{idShoppingKart}/{idProduct}", method = RequestMethod.PUT, produces = "application/json")
	public String addProduct( @PathVariable(name="idShoppingKart") Long idShoppingKart,
							@PathVariable(name="idProduct") Long idProduct){
		return "Product " + idProduct + " added to Kart " + idShoppingKart + "!";
	}
}
