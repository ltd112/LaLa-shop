package com.dat.LaLa_shop.service;

import com.dat.LaLa_shop.model.Cart;

import java.math.BigDecimal;

public interface CartService {

    Cart getCart(Long id);

    void cleanCart(Long id);

    BigDecimal getTotalPrice(Long id);

    Long initializeNewCart();

    Cart getCartByUserId(Long userId);
}
