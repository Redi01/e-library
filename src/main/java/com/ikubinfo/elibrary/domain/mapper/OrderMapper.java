package com.ikubinfo.elibrary.domain.mapper;

import com.ikubinfo.elibrary.domain.dto.order.OrderDTO;
import com.ikubinfo.elibrary.domain.entity.OrderUI;

public class OrderMapper {
    public static OrderDTO toDto(OrderUI o) {
        return OrderDTO.builder()
                .id(o.getId())
                .customerName(o.getCustomerName())
                .totalAmount(o.getTotalAmount())
                .build();
    }

    public static OrderUI toEntity(OrderUI entity){

        return OrderUI.builder()
                .id(entity.getId())
                .books(entity.getBooks())
                .createdAt(entity.getCreatedAt())
                .totalAmount(entity.getTotalAmount())
                .customerName(entity.getCustomerName())
                .build();
    }

}
