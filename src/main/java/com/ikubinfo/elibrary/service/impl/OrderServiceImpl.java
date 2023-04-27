package com.ikubinfo.elibrary.service.impl;

import com.ikubinfo.elibrary.domain.dto.order.OrderDTO;
import com.ikubinfo.elibrary.domain.entity.Order;
import com.ikubinfo.elibrary.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    @Override
    public List<OrderDTO> createOrder(Order order) {
        return null;
    }

    @Override
    public List<OrderDTO> getOrderById(String Id) {
        return null;
    }
}

