package com.ikubinfo.elibrary.domain.dto.order;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OrderDTO {

    private String customerName;
    private Double totalAmount;
    private LocalDateTime createdAt;


}
