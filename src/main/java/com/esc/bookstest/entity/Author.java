package com.esc.bookstest.entity;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Data
@Entity
@Table(name = "authors")
public class Author extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "name", nullable = false, columnDefinition = "nvarchar(100)")
    private String name;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name = "born")
    private Date born;

    @OneToMany(mappedBy = "author_id")
    private List<AuthorBook> authorBooks;
}
