package com.ecommerce.checkout.application.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ecommerce.checkout.application.dto.PaymentDTO;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.model.Token;
import com.stripe.param.ChargeCreateParams;

@Service
public class PaymentService {

    @Value("${stripe.secret.key}")
    String secretKey;
    
    
    public String createToken() throws StripeException {
        Stripe.apiKey = secretKey;
        
        Map<String, Object> card = new HashMap<>();
        card.put("number", "4242424242424242");
        card.put("exp_month", 9);
        card.put("exp_year", 2022);
        card.put("cvc", "314");
        Map<String, Object> params = new HashMap<>();
        params.put("card", card);
        

        Token token = Token.create(params);
        return token.getId();
    }


    public PaymentDTO pay(PaymentDTO paymentDTO) throws StripeException {
        Stripe.apiKey = secretKey;
        
        String token = createToken();    
        paymentDTO.setToken(token);
        
        ChargeCreateParams chargeParams =
        		  ChargeCreateParams.builder()
        		    .setAmount(paymentDTO.getAmount())
        		    .setCurrency(paymentDTO.getCurrency())
        		    .setSource(paymentDTO.getToken())
        		    .build();
        
		Charge charge = Charge.create(chargeParams);
		
		paymentDTO.setChargeId(charge.getId());
		paymentDTO.setPaymentStatus(charge.getStatus());

		return paymentDTO;
    }
    
}
