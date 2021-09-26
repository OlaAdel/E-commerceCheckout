package com.ecommerce.checkout.domain.shared;


import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter @NoArgsConstructor
public class Money {
	
	private double amount;
	
	public Money(double _amount) {
		this.amount = _amount;
	}
	
	public Money multiply(int quantity) {
		return new Money(this.amount * quantity);
	}
	
	public Money add(Money other) {
		return new Money(this.amount + other.amount);
	}
	
	public Long ofPiaster() {
		return (long) (this.amount * 100);
	}

}
