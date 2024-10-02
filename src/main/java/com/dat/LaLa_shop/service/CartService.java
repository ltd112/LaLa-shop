package com.dat.LaLa_shop.service;

import com.dat.LaLa_shop.model.Cart;
import com.dat.LaLa_shop.model.User;

import java.math.BigDecimal;

public interface CartService {

    Cart getCart(Long id);

    void cleanCart(Long id);

    BigDecimal getTotalPrice(Long id);

    Cart initializeNewCart(User user);

    Cart getCartByUserId(Long userId);
}
