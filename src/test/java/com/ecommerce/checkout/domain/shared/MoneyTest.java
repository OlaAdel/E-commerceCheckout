package com.ecommerce.checkout.domain.shared;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MoneyTest {

	@Test
	void OfPiaster() {
		Money money = new Money(390);
		
		assertEquals(money.ofPiaster(), 39000);
	}
	
	@Test
	void Add() {
		Money money = new Money(390).add(new Money(510));
		
		assertEquals(money.getAmount(), 900);
	}
	
	@Test
	void multiply() {
		
		Money money = new Money(25).multiply(3);
		
		assertEquals(money.getAmount(), 75);
	}

}
