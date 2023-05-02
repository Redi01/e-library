package com.ikubinfo.elibrary.domain.dto.order;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OrderDTO {
    private Long id;
    private String customerName;
    private Double totalAmount;
}
