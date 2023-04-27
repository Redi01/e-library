package com.ikubinfo.elibrary.domain.entity;

import javax.persistence.*;

@Entity
public class Borrow {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToOne
    private BookEntity book;

    @OneToOne
    private User userBorrowedTo;

    @OneToOne
    private User userBorrowedFrom;

    private Long days;

    private Long margin ; // 2 dite

    // vendos nje metode te skeduluar qe kontrollon perdite se cilet usera nuk i kane sjelle librat
    // skedulo - metode qe ekzekutohet vete perdite -> ruaji ne nje tabele ne db te userat qe
    // @Schedule - bej research
    // te useri - shto nje kolone --- numri i librave qe nuk ka sjelle
}
