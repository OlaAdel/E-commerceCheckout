package com.ecommerce.checkout.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.ecommerce.checkout.domain.shared.BasketPaymentStatus;
import com.ecommerce.checkout.domain.shared.Money;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter  
@Setter
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "basket")
    private List<BasketItem> orderItems = new ArrayList<>();
    
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    
    @Enumerated(EnumType.STRING)
    private BasketPaymentStatus paymentStatus;
    
    @Embedded
    private Money totalPrice;
    
    public Basket() {
    	
    }
    
    public void calculateTotalPrice() {
    	this.totalPrice = this.getOrderItems()
    					  .stream()
    					  .map(BasketItem::calculateBasketItemPrice)
    					  .reduce(new Money(0), Money::add);
    }
}
