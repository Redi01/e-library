package com.ikubinfo.elibrary.controller;

import com.ikubinfo.elibrary.domain.entity.OrderUI;
import com.ikubinfo.elibrary.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderUI> createOrder(@RequestBody OrderUI order) {
        OrderUI createdOrder = (OrderUI) orderService.createOrder(order);
        return new ResponseEntity<>(createdOrder, HttpStatus.CREATED);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderUI> getOrderById(@PathVariable Long orderId) {
        OrderUI order = (OrderUI) orderService.getOrderById(String.valueOf(orderId));
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

}
