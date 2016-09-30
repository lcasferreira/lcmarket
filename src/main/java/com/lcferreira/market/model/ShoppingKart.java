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

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="shopping_kart")
@SequenceGenerator(name="shoppingKartSequence", sequenceName="shopping_kart_seq", allocationSize = 1)
public class ShoppingKart extends BasicEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7077501508374084997L;
	
	@Setter
	private List<ShoppingKartItem> items = new ArrayList<ShoppingKartItem>();
	
	@Getter @Setter
	@Enumerated(EnumType.ORDINAL)
	private ShoppingKartStatus status = ShoppingKartStatus.BUYING;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="shoppingKartSequence")
	public Long getId() {
		return this.id;
	}

	@OneToMany(mappedBy="shoppingKart", orphanRemoval = true)
	public List<ShoppingKartItem> getItems() {
		return items;
	}
	
	public void addProduct(Product product){
		if(items.contains(product)){
			items.forEach(item->{
				if(item.getProduct().equals(product)){
					item.incrementQty();
				}
			});
		} else {
			ShoppingKartItem newItem = new ShoppingKartItem(product);
			newItem.setShoppingKart(this);
			items.add(newItem);
		}
	}
	
	public void clearItems(){
		items.clear();
	}
	
	public BigDecimal getTotal(){
		BigDecimal sum = BigDecimal.ZERO;
		items.forEach(item->{
			sum.add(item.getProduct().getPrice().multiply(new BigDecimal(item.getQty())));
		});
		return sum;
	}
}
