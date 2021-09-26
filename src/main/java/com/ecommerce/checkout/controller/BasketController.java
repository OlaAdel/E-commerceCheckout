package com.ecommerce.checkout.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.checkout.application.dto.BasketDTO;
import com.ecommerce.checkout.application.dto.PaymentDTO;
import com.ecommerce.checkout.application.exception.BasketNotFoundException;
import com.ecommerce.checkout.application.exception.CloseBasketValidationException;
import com.ecommerce.checkout.application.service.BasketApplicationService;
import com.ecommerce.checkout.application.service.PaymentService;
import com.ecommerce.checkout.domain.Basket;
import com.ecommerce.checkout.domain.shared.BasketPaymentStatus;
import com.stripe.exception.StripeException;


@RestController
@RequestMapping("/baskets")
public class BasketController {
	
	private final BasketApplicationService basketService;
	private final PaymentService paymentService;

	
	@Autowired
	public BasketController(BasketApplicationService _baskerSerive, PaymentService _paymentService) {
		this.basketService = _baskerSerive;
		this.paymentService = _paymentService;

	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getBasket(@PathVariable("id") Long id) {
			Basket basket = null;
			try {
				basket = basketService.getBasekt(id);
			} catch (BasketNotFoundException e) {
		        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
		return new ResponseEntity<Basket>(basket, HttpStatus.OK); 
	}
	
	@PostMapping("close-basket/{id}")
	public ResponseEntity<?> closeBasket(@PathVariable("id") Long id) {
			
			BasketDTO basketDTO = null;
			PaymentDTO paymentDTO = null;
			
			try {
				
			    basketDTO = basketService.closeBasket(id);
	
			    paymentDTO = paymentService.pay(new PaymentDTO(null, basketDTO.getTotalPrice().ofPiaster(), "usd", null, null));
			    
			    if(paymentDTO.getPaymentStatus().equals("succeeded"))
			    {
			    	basketDTO.setPaymentStatus(BasketPaymentStatus.PAID);
			    	basketService.setBasketPaymentStatus(id, BasketPaymentStatus.PAID);
			    }

			    	
			} catch (BasketNotFoundException e) {
		        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			} catch (CloseBasketValidationException e) {
		  	  	return new ResponseEntity<String>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
			} catch (StripeException e) {
		  	  	return new ResponseEntity<String>(e.getMessage(), HttpStatus.valueOf(e.getStatusCode()));
			}
			
		return new ResponseEntity<BasketDTO>(basketDTO, HttpStatus.OK);
	}

}


