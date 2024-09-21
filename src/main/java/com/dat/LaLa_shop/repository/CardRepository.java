package com.dat.LaLa_shop.repository;

import com.dat.LaLa_shop.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Cart, Long> {
    Cart findByUserId(Long userId);
}
