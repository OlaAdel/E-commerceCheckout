package com.ecommerce.checkout.application.validation.rule;

import static org.junit.jupiter.api.Assertions.*;

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

class MinimumPriceTest {

	@Test
	void apply() {
		
		CloseBasketValidation validations = new MinimumPrice();
		Basket basket = new Basket();
		
		List<BasketItem> ordersTestList = new ArrayList<BasketItem>
		  			(Arrays.asList(new BasketItem(null, 2, new Product(null, "hair-clips", new Money(20), true), null),
		  					new BasketItem(null, 1, new Product(null, "shirt", new Money(40), true), null)));
		basket.setOrderItems(ordersTestList);
	
		basket.calculateTotalPrice();
		EnumSet<CloseBasketValidationResult> validationResult = validations.apply(basket);
		
		assertEquals(validationResult, EnumSet.of(CloseBasketValidationResult.TOTAL_PRICE_SHOULD_BE_GREATER_THAN_100));		
	}

}
