package com.ecommerce.checkout.application.validation.rule;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.ecommerce.checkout.application.validation.CloseBasketValidation;
import com.ecommerce.checkout.application.validation.CloseBasketValidationResult;
import com.ecommerce.checkout.domain.Basket;
import com.ecommerce.checkout.domain.BasketItem;
import com.ecommerce.checkout.domain.Product;
import com.ecommerce.checkout.domain.shared.Money;

class ItemsAvailabilityTest {

	@Test
	void apply() {
		
		CloseBasketValidation validations = new ItemsAvailability();
		Basket basket = new Basket();
		
		List<BasketItem> ordersTestList = new ArrayList<BasketItem>
				  (Arrays.asList(new BasketItem((long) 1, 5, new Product((long) 1, "pants", new Money(100), true), null),
						  new BasketItem((long) 2, 2, new Product((long) 2, "dress", new Money(150), false), null),
						  new BasketItem((long) 3, 1, new Product((long) 3, "shirt", new Money(200), true), null)));
		basket.setOrderItems(ordersTestList);
		
		EnumSet<CloseBasketValidationResult> validationResult = validations.apply(basket);
		
		assertEquals(validationResult, EnumSet.of(CloseBasketValidationResult.THERE_ARE_SOME_ITEMS_THAT_ARE_NOT_AVAILABLE));		
	}

}
