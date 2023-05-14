package com.ikubinfo.elibrary.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "borrows")
public class BorrowEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "book_id")
    private BookEntity book;

    @OneToOne
    @JoinColumn(name = "borrowed_to_user_id")
    private User userBorrowedTo;

    @OneToOne
    @JoinColumn(name = "borrowed_from_user_id")
    private User userBorrowedFrom;

    @Column(name = "days")
    private Long days;

    @Column(name = "margin")
    private Long margin;// 2 dite

    // vendos nje metode te skeduluar qe kontrollon perdite se cilet usera nuk i kane sjelle librat
    // skedulo - metode qe ekzekutohet vete perdite -> ruaji ne nje tabele ne db te userat qe
    // @Schedule - bej research
    // te useri - shto nje kolone --- numri i librave qe nuk ka sjelle
}
