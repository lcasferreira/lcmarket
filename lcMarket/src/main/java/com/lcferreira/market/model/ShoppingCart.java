package com.lcferreira.market.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
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
	
	@Setter
	private ShoppingCartStatus status = ShoppingCartStatus.BUYING;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="shoppingKartSequence")
	public Long getId() {
		return this.id;
	}

	@OneToMany(mappedBy="shoppingKart", orphanRemoval = true, cascade = CascadeType.ALL)
	public List<ShoppingCartItem> getItems() {
		return items;
	}
	
	@Enumerated(EnumType.ORDINAL)
	public ShoppingCartStatus getStatus() {
		return status;
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
	
	public void removeProduct(Long idProduct){
		List<ShoppingCartItem> copyOfList = new ArrayList<ShoppingCartItem>(items);
		items.clear();
		for (ShoppingCartItem item : copyOfList) {
			if(item.getProduct().getId().equals(idProduct)){
				if(item.getQty() > 1){
					item.decrementQty();
				} else {
					continue;
				}
			}
			items.add(item);
		}
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
		Integer qty = items.stream().mapToInt(ShoppingCartItem::getQty).sum();
		return qty;
	}
}
