package com.lcferreira.market.model;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class ShoppingCartItemTest {
	
	Product product;
	ShoppingCartItem cartItem;
	
	@Before
	public void init(){
		product = new Product();
		product.setName("Product Test");
		product.setPrice(new BigDecimal(50));
		
		cartItem = new ShoppingCartItem(product);
	}

	@Test
	public void getTotalPriceNullProductTest(){
		
		cartItem.setProduct(null);

		assertEquals(BigDecimal.ZERO, cartItem.getTotalPrice());
	}
	
	@Test
	public void getTotalPriceNullProductPriceTest(){
		
		cartItem.getProduct().setPrice(null);

		assertEquals(BigDecimal.ZERO, cartItem.getTotalPrice());
	}
	
	@Test
	public void getTotalPriceNoProductsTest(){
		
		cartItem.setQty(0);

		assertEquals(BigDecimal.ZERO, cartItem.getTotalPrice());
	}
	
	@Test
	public void getTotalPriceWithProductsTest(){
		
		cartItem.setQty(3);

		assertEquals(new BigDecimal(150), cartItem.getTotalPrice());
	}
}
