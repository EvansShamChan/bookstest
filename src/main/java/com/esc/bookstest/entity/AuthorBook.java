package com.esc.bookstest.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "author_book")
public class AuthorBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "author_id")
    private Long author_id;

    @Column(name = "book_id")
    private Long book_id;
}
