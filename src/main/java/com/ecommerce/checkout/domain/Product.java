package com.ecommerce.checkout.domain;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.ecommerce.checkout.domain.shared.Money;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Entity
@Getter 
@AllArgsConstructor
public class Product {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
    @Embedded
	private Money price;
	
	private boolean isAvailable;
	
	public Product() {
		
	}

}
