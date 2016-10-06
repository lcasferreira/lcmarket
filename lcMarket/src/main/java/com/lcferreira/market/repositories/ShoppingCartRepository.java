package com.lcferreira.market.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.lcferreira.market.model.ShoppingCart;
import com.lcferreira.market.model.ShoppingCartStatus;

public interface ShoppingCartRepository extends CrudRepository<ShoppingCart, Long>{

	/**
	 * Method to return the open shopping cart (BUYING), if exists login, 
	 * this method should be changed to be used for each user.
	 * 
	 * @return
	 */
	@Query("select sc from ShoppingCart sc where sc.status = ?")
	public ShoppingCart getShoppingCartByStatus(ShoppingCartStatus status);
}
