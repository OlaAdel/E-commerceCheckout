package com.ecommerce.checkout.application.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PaymentDTO {
    private String token;
    private Long amount;
    private String currency;
	private String chargeId;
    private String paymentStatus;
}
