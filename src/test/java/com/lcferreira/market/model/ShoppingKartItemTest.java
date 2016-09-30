package com.lcferreira.market.model;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class ShoppingKartItemTest {
	
	Product product;
	ShoppingKartItem kartItem;
	
	@Before
	public void init(){
		product = new Product();
		product.setName("Product Test");
		product.setPrice(new BigDecimal(50));
		
		kartItem = new ShoppingKartItem(product);
	}

	@Test
	public void getTotalPriceNullProductTest(){
		
		kartItem.setProduct(null);

		assertEquals(BigDecimal.ZERO, kartItem.getTotalPrice());
	}
	
	@Test
	public void getTotalPriceNullProductPriceTest(){
		
		kartItem.getProduct().setPrice(null);

		assertEquals(BigDecimal.ZERO, kartItem.getTotalPrice());
	}
	
	@Test
	public void getTotalPriceNoProductsTest(){
		
		kartItem.setQty(0);

		assertEquals(BigDecimal.ZERO, kartItem.getTotalPrice());
	}
	
	@Test
	public void getTotalPriceWithProductsTest(){
		
		kartItem.setQty(3);

		assertEquals(new BigDecimal(150), kartItem.getTotalPrice());
	}
}
