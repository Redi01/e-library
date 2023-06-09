package com.ikubinfo.elibrary.domain.dto.book;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookDTO {
    private String title;
    private String author;
    private String description;
    private Integer quantity;
    private Integer price;
}
