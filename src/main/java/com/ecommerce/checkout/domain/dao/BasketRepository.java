package com.ecommerce.checkout.domain.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.checkout.domain.Basket;

@Repository
public interface BasketRepository extends JpaRepository<Basket,Long> {

}
