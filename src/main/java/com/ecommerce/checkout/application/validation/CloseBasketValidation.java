package com.ecommerce.checkout.application.validation;

import java.util.EnumSet;
import java.util.function.Function;

import com.ecommerce.checkout.domain.Basket;

public interface CloseBasketValidation extends Function<Basket, EnumSet<CloseBasketValidationResult>> {

    static final EnumSet<CloseBasketValidationResult> SUCCESS_ONLY = EnumSet.of(CloseBasketValidationResult.SUCCESS);

	default CloseBasketValidation and(CloseBasketValidation other) {
        return basket -> {
        	
            EnumSet<CloseBasketValidationResult> thisResult = this.apply(basket);
            EnumSet<CloseBasketValidationResult> otherResult = other.apply(basket);
            
            if (thisResult.equals(SUCCESS_ONLY))
                return otherResult;
            if (otherResult.equals(SUCCESS_ONLY))
                return thisResult;
            
            EnumSet<CloseBasketValidationResult> combinedResult = EnumSet.copyOf(thisResult);
            combinedResult.addAll(otherResult);
            
            return combinedResult;
        };
    }
	

}
