package com.lcferreira.market.model;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Setter
@SequenceGenerator(name="purchaseOrderSequence", sequenceName="purchase_order_seq", allocationSize = 1)
public class PurchaseOrder extends BasicEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7435173586892957841L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="purchaseOrderSequence")
	public Long getId() {
		return id;
	}
	
	@Getter
	private String number;
	
	@Getter
	@Temporal(TemporalType.DATE)
	private Calendar date;
	
	@Getter
	private BigDecimal discount;
	
	@Getter
	private BigDecimal total;
	
	@OneToOne(optional = false)
	@JoinColumn(name="shopping_kart_id", referencedColumnName="id")
	private ShoppingCart shoppingCart;
	
}
