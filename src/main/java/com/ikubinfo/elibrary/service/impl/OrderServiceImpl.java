package com.ikubinfo.elibrary.service.impl;

import com.ikubinfo.elibrary.domain.dto.order.OrderDTO;
import com.ikubinfo.elibrary.domain.entity.OrderUI;
import com.ikubinfo.elibrary.domain.exception.ResourceNotFoundException;
import com.ikubinfo.elibrary.domain.mapper.OrderMapper;
import com.ikubinfo.elibrary.repository.OrderRepository;
import com.ikubinfo.elibrary.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public OrderDTO createOrder(OrderDTO orderDTO) {
        OrderUI order = OrderMapper.toEntity(orderDTO);
        order.setCreatedAt(LocalDateTime.now());

        OrderUI savedOrder = orderRepository.save(order);

        return OrderMapper.toDto(savedOrder);
    }

    @Override
    public OrderDTO getOrderById(Long id) {
        return orderRepository.findById(id).map(OrderMapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Order with id %s not found ", id)));
    }

    @Override
    public void deleteOrderById(Long id) {
        OrderUI order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Order with id %s not found ", id)));
        orderRepository.delete(order);
    }


}

