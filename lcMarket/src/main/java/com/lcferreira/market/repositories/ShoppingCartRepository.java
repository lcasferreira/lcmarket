package com.lcferreira.market.repositories;

import org.springframework.data.repository.CrudRepository;

import com.lcferreira.market.model.ShoppingCart;

public interface ShoppingCartRepository extends CrudRepository<ShoppingCart, Long>{

	
}
