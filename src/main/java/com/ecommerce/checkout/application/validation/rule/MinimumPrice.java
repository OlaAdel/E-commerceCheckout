package com.ecommerce.checkout.application.validation.rule;

import java.util.EnumSet;

import com.ecommerce.checkout.application.validation.CloseBasketValidation;
import com.ecommerce.checkout.application.validation.CloseBasketValidationResult;
import com.ecommerce.checkout.domain.Basket;

public class MinimumPrice implements CloseBasketValidation {

	public EnumSet<CloseBasketValidationResult> apply(Basket _basket) {
		return  _basket.getTotalPrice().getAmount() > 100 ?
				SUCCESS_ONLY  : EnumSet.of(CloseBasketValidationResult.TOTAL_PRICE_SHOULD_BE_GREATER_THAN_100);
		}
}
