package com.ecommerce.checkout.application.dto;

import java.util.EnumSet;

import com.ecommerce.checkout.application.validation.CloseBasketValidationResult;
import com.ecommerce.checkout.domain.shared.BasketPaymentStatus;
import com.ecommerce.checkout.domain.shared.Money;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BasketDTO {
	BasketPaymentStatus paymentStatus;
	Money totalPrice;
	EnumSet<CloseBasketValidationResult> validationResult;
}
