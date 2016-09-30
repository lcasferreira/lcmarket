package com.lcferreira.market.model;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class ShoppingCartTest {

	private static final BigDecimal BOOK_PRICE = new BigDecimal(25);
	private static final BigDecimal MAGAZINE_PRICE = new BigDecimal(15.5);
	private static final BigDecimal KINDLE_PRICE = new BigDecimal(199.5);
	
	private Product book;
	private Product magazine;
	private Product kindle;
	
	private ShoppingCart cart;
	
	@Before
	public void init(){
		cart = new ShoppingCart();
		createProducts();
	}
	
	@Test
	public void addProductTest(){

		cart.addProduct(book);
		
		assertNotNull(cart);
		assertEquals(1, cart.getQtyItemsInKart().intValue());
		assertEquals(BOOK_PRICE, cart.getTotalPrice());
		
	}

	private void createProducts(){
		book = new Product("Book", BOOK_PRICE);
		book.setId(1L);
		
		magazine = new Product("Magazine", MAGAZINE_PRICE);
		magazine.setId(2L);
		
		kindle = new Product("Kindle", KINDLE_PRICE);
		kindle.setId(3L);
	}
}
