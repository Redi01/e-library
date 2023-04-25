package com.ikubinfo.elibrary.domain.mapper;

import com.ikubinfo.elibrary.domain.dto.book.BookDTO;
import com.ikubinfo.elibrary.domain.entity.BookEntity;

public class BookMapper {

    // BookDTO toDto(BookEntity entity) ;
    // BookEntity toEntity(BookDto dto) ;

    public static BookDTO toDto(BookEntity entity){
        return BookDTO.builder()
                .id(entity.getId())
                .author(entity.getAuthor())
                .title(entity.getTitle())
                .description(entity.getDescription())
                .build();
    }

    public static BookEntity toEntity(BookDTO dto){
        return BookEntity.builder()
                .author(dto.getAuthor())
                .title(dto.getTitle())
                .description(dto.getDescription())
                .build();
    }
}
