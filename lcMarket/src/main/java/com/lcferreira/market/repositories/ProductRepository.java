package com.lcferreira.market.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.lcferreira.market.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long>{  
	
	@Query("select p from Product p where p.name like '%'+?1+'%'")
	List<Product> getProductsByName(String name);
}
