package com.esc.bookstest.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Data
@Entity
@Table(name = "books")
public class Book extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "published", nullable = false)
    private Date published;

    @Column(name = "genre", nullable = false)
    private String genre;

    @Column(name = "rating", nullable = false)
    private Integer rating;

    @OneToMany(mappedBy = "book_id")
    private List<AuthorBook> authorBooks;
}
