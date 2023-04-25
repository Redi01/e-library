package com.ikubinfo.elibrary.controller;

import com.ikubinfo.elibrary.domain.entity.Order;
import com.ikubinfo.elibrary.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        Order createdOrder = (Order) orderService.createOrder(order);
        return new ResponseEntity<>(createdOrder, HttpStatus.CREATED);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long orderId) {
        Order order = (Order) orderService.getOrderById(String.valueOf(orderId));
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

}
