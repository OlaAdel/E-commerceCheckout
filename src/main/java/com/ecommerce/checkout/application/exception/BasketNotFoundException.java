package com.ecommerce.checkout.application.exception;


public class BasketNotFoundException extends RuntimeException {

	 public BasketNotFoundException() {
	 }

	 public BasketNotFoundException(String message) {
	        super(message);
	 }
}
