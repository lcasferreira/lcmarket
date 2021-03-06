package com.lcferreira.market.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="shopping_kart_item")
@SequenceGenerator(name="shoppingKartItemSequence", sequenceName="shopping_kart_item_seq", allocationSize = 1)
public class ShoppingCartItem extends BasicEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5577810003698959030L;

	@Setter
	private Product product;
	
	@Setter
	@JsonIgnore
	private ShoppingCart shoppingKart;
	
	@Getter @Setter
	private Integer qty = 0;
	
	public ShoppingCartItem() { }
	
	public ShoppingCartItem(Product product) {
		this.product = product;
		this.qty = 1;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="shoppingKartItemSequence")
	public Long getId() {
		return id;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="shopping_kart_id", referencedColumnName="id")
	public ShoppingCart getShoppingKart() {
		return shoppingKart;
	}

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name="product_id", referencedColumnName="id")
	public Product getProduct() {
		return product;
	}
	
	public void incrementQty(){
		qty++;
	}
	
	public void decrementQty(){
		qty--;
	}
	
	public void resetQty(){
		qty = 0;
	}

	@Transient
	public BigDecimal getTotalPrice(){
		if(product != null && product.getPrice() != null){
			return product.getPrice().multiply(new BigDecimal(qty));
		}
		return BigDecimal.ZERO;
	}
}
