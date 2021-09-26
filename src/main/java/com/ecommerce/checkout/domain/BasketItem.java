package com.ecommerce.checkout.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.ecommerce.checkout.domain.shared.Money;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Entity
@Getter  
@AllArgsConstructor
public class BasketItem {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private int quantity;

	@OneToOne
	@JoinColumn(name = "product_id")
	private Product product;
    
	@JsonBackReference
    @ManyToOne
    @JoinColumn(name = "basket_id")
    private Basket basket;
	
	public BasketItem() {
		
	}
	public Money calculateBasketItemPrice() {
		return this.product.getPrice().multiply(this.quantity);
	}

}
