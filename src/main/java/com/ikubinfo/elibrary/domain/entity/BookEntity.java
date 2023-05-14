package com.ikubinfo.elibrary.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Books")
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private String description;
    private Integer quantity;
    private Integer price;
    private String borrowerName;
    private String borrowedBy;
    private LocalDateTime borrowDate;
    @ManyToMany(cascade = {CascadeType.ALL})
    private List<OrderUI> orders;
    @ManyToMany
    private List<User> user;

}
