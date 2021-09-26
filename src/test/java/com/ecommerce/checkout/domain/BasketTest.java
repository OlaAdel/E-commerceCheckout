package com.ecommerce.checkout.domain;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.ecommerce.checkout.domain.shared.Money;

class BasketTest {
	
    private Basket basket;

	@Test
	void calculateTotalPrice() {
		basket = new Basket();
		
		List<BasketItem> ordersTestList = new ArrayList<BasketItem>
				  (Arrays.asList(new BasketItem(null, 5, new Product(null, "pants", new Money(100), true), null),
						  new BasketItem(null, 2, new Product(null, "dress", new Money(150), true), null),
						  new BasketItem(null, 1, new Product(null, "shirt", new Money(200), true), null)));
		basket.setOrderItems(ordersTestList);

		basket.calculateTotalPrice();
		
		assertEquals(basket.getTotalPrice().getAmount(), 1000);		
	}

}
