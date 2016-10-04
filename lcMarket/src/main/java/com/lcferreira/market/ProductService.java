package com.lcferreira.market;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcferreira.market.model.Product;
import com.lcferreira.market.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> getAllProducts(){
		List<Product> products = new ArrayList<Product>();
		
		Iterable<Product> resultList = productRepository.findAll();
		
		
		if(resultList != null && resultList.iterator().hasNext()){
			products = StreamSupport.stream(
		            Spliterators.spliteratorUnknownSize(resultList.iterator(),
		                    Spliterator.ORDERED), false).collect(
		            Collectors.<Product> toList());
		}
		
		return products;
	}
}
