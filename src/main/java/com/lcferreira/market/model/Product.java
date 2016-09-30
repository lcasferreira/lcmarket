package com.lcferreira.market.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="product")
@SequenceGenerator(name="productSequence", sequenceName="product_seq", allocationSize = 1)
public class Product extends BasicEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8285355806284186372L;

	@Getter @Setter
	private String name;
	
	@Getter @Setter
	private BigDecimal price;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="productSequence")
	public Long getId() {
		return id;
	}
	
	public Product() { }
	
	public Product(String name, BigDecimal price) {
		this.name = name;
		this.price = price;
	}
	
}
