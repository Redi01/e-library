package com.ikubinfo.elibrary.domain.mapper;

import com.ikubinfo.elibrary.domain.dto.book.BookDTO;
import com.ikubinfo.elibrary.domain.entity.BookEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class BookMapper {

    // BookDTO toDto(BookEntity entity) ;
    // BookEntity toEntity(BookDto dto) ;

    public static BookDTO toDto(BookEntity entity){
        return BookDTO.builder()
                .author(entity.getAuthor())
                .title(entity.getTitle())
                .price(entity.getPrice())
                .quantity(entity.getQuantity())
                .description(entity.getDescription())
                .build();
    }

    public static BookEntity toEntity(BookDTO dto){
        return BookEntity.builder()
                .author(dto.getAuthor())
                .title(dto.getTitle())
                .price(dto.getPrice())
                .quantity(dto.getQuantity())
                .description(dto.getDescription())
                .build();
    }

    public List<BookDTO> toDtoList(List<BookEntity> bookEntities) {
        List<BookDTO> bookDTOs = new ArrayList<>();
        for (BookEntity bookEntity : bookEntities) {
            bookDTOs.add(toDto(bookEntity));
        }
        return bookDTOs;
    }

}
