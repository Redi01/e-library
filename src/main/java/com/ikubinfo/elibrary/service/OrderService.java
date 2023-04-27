package com.ikubinfo.elibrary.service;

import com.ikubinfo.elibrary.domain.dto.order.OrderDTO;
import com.ikubinfo.elibrary.domain.entity.Order;

import java.util.List;

public interface OrderService {
    List<OrderDTO> createOrder(Order order);
    List<OrderDTO>  getOrderById(String Id);
}
