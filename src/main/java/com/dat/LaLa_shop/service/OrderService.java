package com.dat.LaLa_shop.service;

import com.dat.LaLa_shop.dto.OrderDto;
import com.dat.LaLa_shop.model.Order;

import java.util.List;

public interface OrderService {
    Order placeOrder(Long userId);
    OrderDto getOrder(Long orderId);
    List<OrderDto> getUserOrders(Long userId);

    OrderDto convertToDto(Order order);
}
