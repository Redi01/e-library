package com.ikubinfo.elibrary.domain.mapper;

import com.ikubinfo.elibrary.domain.dto.order.OrderDTO;
import com.ikubinfo.elibrary.domain.entity.OrderUI;

public class OrderMapper {
    public static OrderDTO toDto(OrderUI o) {
        return OrderDTO.builder()
                .customerName(o.getCustomerName())
                .createdAt(o.getCreatedAt())
                .totalAmount(o.getTotalAmount())
                .build();
    }

    public static OrderUI toEntity(OrderDTO entity){

        return OrderUI.builder()
                .totalAmount(entity.getTotalAmount())
                .customerName(entity.getCustomerName())
                .createdAt(entity.getCreatedAt())
                .build();
    }

}
