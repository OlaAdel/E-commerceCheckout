package com.ecommerce.checkout.application.validation.rule;

import java.util.EnumSet;

import com.ecommerce.checkout.application.validation.CloseBasketValidation;
import com.ecommerce.checkout.application.validation.CloseBasketValidationResult;
import com.ecommerce.checkout.domain.Basket;

public class ItemsAvailability implements CloseBasketValidation {

	public EnumSet<CloseBasketValidationResult> apply(Basket _basket) {
		return  _basket.getOrderItems().stream().map(item -> item.getProduct()).allMatch(product -> product.isAvailable()) ?
				SUCCESS_ONLY  : EnumSet.of(CloseBasketValidationResult.THERE_ARE_SOME_ITEMS_THAT_ARE_NOT_AVAILABLE);

	}

}
