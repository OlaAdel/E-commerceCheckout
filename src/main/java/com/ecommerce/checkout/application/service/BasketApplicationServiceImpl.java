package com.ecommerce.checkout.application.service;

import java.util.EnumSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.checkout.application.dto.BasketDTO;
import com.ecommerce.checkout.application.exception.BasketNotFoundException;
import com.ecommerce.checkout.application.exception.CloseBasketValidationException;
import com.ecommerce.checkout.application.validation.CloseBasketValidation;
import com.ecommerce.checkout.application.validation.CloseBasketValidationResult;
import com.ecommerce.checkout.application.validation.rule.ItemsAvailability;
import com.ecommerce.checkout.application.validation.rule.MaximumPrice;
import com.ecommerce.checkout.application.validation.rule.MinimumPrice;
import com.ecommerce.checkout.domain.Basket;
import com.ecommerce.checkout.domain.dao.BasketRepository;
import com.ecommerce.checkout.domain.shared.BasketPaymentStatus;

@Service
public class BasketApplicationServiceImpl implements BasketApplicationService {

	private final BasketRepository basketRepository;

	@Autowired
	public BasketApplicationServiceImpl(BasketRepository _basketRepository) {
		this.basketRepository = _basketRepository;
	}
	
	
	public Basket getBasekt(Long id) {
		Basket basket = basketRepository.findById(id)
			       		.orElseThrow( () -> new BasketNotFoundException());
		return basket;
	}
	
	public void calculateTotalPrice(Basket _basket) {

		_basket.calculateTotalPrice();
		basketRepository.save(_basket);
	}
	
	public void setBasketPaymentStatus(Long id, BasketPaymentStatus status) {

		Basket basket = getBasekt(id);
		basket.setPaymentStatus(status);
		basketRepository.save(basket);
	}
	
	
	
	public EnumSet<CloseBasketValidationResult> runValidationRules(Basket _basket) {
		
		CloseBasketValidation validations = new MaximumPrice().and(new ItemsAvailability()).and(new MinimumPrice());
		
		EnumSet<CloseBasketValidationResult> validationResult = validations.apply(_basket);
		if(!validationResult.equals(CloseBasketValidation.SUCCESS_ONLY))
			throw new CloseBasketValidationException(validationResult.toString());
		
		return validationResult;
	}
	

	public BasketDTO closeBasket(Long id) {
		Basket basket = getBasekt(id);
		
		basket.calculateTotalPrice();
		
		EnumSet<CloseBasketValidationResult> validationResult = runValidationRules(basket);
		
		return new BasketDTO(basket.getPaymentStatus(), basket.getTotalPrice(), validationResult);	
	}


}
