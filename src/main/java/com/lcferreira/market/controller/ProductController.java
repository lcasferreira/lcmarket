package com.lcferreira.market.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

	private static final String msg = "Hello, %s!";
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET, produces = "application/json")
	public String getWellComeMsg(@RequestParam(value = "name", defaultValue="World") String name){
		return String.format(msg, name);
	}
}
