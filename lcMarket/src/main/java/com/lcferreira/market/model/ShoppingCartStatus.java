package com.lcferreira.market.model;

public enum ShoppingCartStatus {

	/**
	 * Indicates a shopping cart not closed, ie, capable of editing
	 */
	BUYING,

	/**
	 * Indicates a shopping cart already closed, ie, part of a purchase order.
	 */
	BOUGHT;
}
