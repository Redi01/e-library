package com.ikubinfo.elibrary.domain.dto;

import lombok.Data;

@Data
public class ReviewDTO {
    private Integer userId;
    private Integer rating;
    private String comment;
}
