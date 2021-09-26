package com.ecommerce.checkout.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import com.ecommerce.checkout.domain.shared.Money;


class BasketItemTest {

	@Test
	void calculateBasketItemPrice() {
		BasketItem item = new BasketItem(null, 5, new Product(null, null, new Money(30), true), null);
		item.calculateBasketItemPrice();
		assertEquals(item.calculateBasketItemPrice().getAmount(), 150);
	}

}
