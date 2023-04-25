package com.ikubinfo.elibrary.domain.mapper;

import com.ikubinfo.elibrary.domain.dto.order.OrderDTO;
import com.ikubinfo.elibrary.domain.entity.Order;
import org.springframework.security.core.userdetails.User;

import java.util.List;
import java.util.stream.Collectors;

public class OrderMapper {
    public static OrderDTO toDto(Order o) {
        return OrderDTO.builder()
                .id(o.getId())
                .customerName(o.getCustomerName())
                .totalAmount(o.getTotalAmount())
                .build();
    }

}
