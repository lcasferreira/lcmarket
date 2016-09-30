package com.lcferreira.market.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="shopping_kart")
@SequenceGenerator(name="shoppingKartSequence", sequenceName="shopping_kart_seq", allocationSize = 1)
public class ShoppingCart extends BasicEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7077501508374084997L;
	
	@Setter
	private List<ShoppingCartItem> items = new ArrayList<ShoppingCartItem>();
	
	@Getter @Setter
	@Enumerated(EnumType.ORDINAL)
	private ShoppingCartStatus status = ShoppingCartStatus.BUYING;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="shoppingKartSequence")
	public Long getId() {
		return this.id;
	}

	@OneToMany(mappedBy="shoppingKart", orphanRemoval = true)
	public List<ShoppingCartItem> getItems() {
		return items;
	}
	
	public void addProduct(Product product){

		for (ShoppingCartItem item : items) {
			if(item.getProduct().equals(product)){
				item.incrementQty();
				return;
			}
		}
		
		ShoppingCartItem newItem = new ShoppingCartItem(product);
		newItem.setShoppingKart(this);
		items.add(newItem);
	}
	
	public void clearItems(){
		items.clear();
	}
	
	@Transient
	public BigDecimal getTotalPrice(){
		BigDecimal sum = BigDecimal.ZERO;
		for (ShoppingCartItem item : items) {
			sum = sum.add(item.getTotalPrice());
		}
		return sum;
	}
	
	/**
	 * Return amount of items in shopping kart.
	 * @return
	 */
	@Transient
	public Integer getQtyItemsInKart(){
		if(items.isEmpty()){
			return 0;
		}
		return items.stream().mapToInt(ShoppingCartItem::getQty).sum();
	}
}
