package com.ecommerce.checkout.application.service;

import java.util.EnumSet;

import com.ecommerce.checkout.application.dto.BasketDTO;
import com.ecommerce.checkout.application.validation.CloseBasketValidationResult;
import com.ecommerce.checkout.domain.Basket;
import com.ecommerce.checkout.domain.shared.BasketPaymentStatus;

public interface BasketApplicationService {
	Basket getBasekt(Long id);
	
	void calculateTotalPrice(Basket _basket);
	
	void setBasketPaymentStatus(Long id, BasketPaymentStatus status);
	 
	EnumSet<CloseBasketValidationResult> runValidationRules(Basket _basket);

	BasketDTO closeBasket(Long id);	
}
