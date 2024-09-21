package com.dat.LaLa_shop.service.impl;

import com.dat.LaLa_shop.repository.CardRepository;
import com.dat.LaLa_shop.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CardRepository cardRepository;


}
