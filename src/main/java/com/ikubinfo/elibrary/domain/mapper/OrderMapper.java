package com.ikubinfo.elibrary.domain.mapper;

import com.ikubinfo.elibrary.domain.dto.order.OrderDTO;
import com.ikubinfo.elibrary.domain.entity.Order;

public class OrderMapper {
    public static OrderDTO toDto(Order o) {
        return OrderDTO.builder()
                .id(o.getId())
                .customerName(o.getCustomerName())
                .totalAmount(o.getTotalAmount())
                .build();
    }

    public static Order toEntity(Order entity){

        return Order.builder()
                .id(entity.getId())
                .books(entity.getBooks())
                .createdAt(entity.getCreatedAt())
                .totalAmount(entity.getTotalAmount())
                .customerName(entity.getCustomerName())
                .build();
    }

}
