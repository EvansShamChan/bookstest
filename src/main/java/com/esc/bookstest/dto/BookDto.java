package com.esc.bookstest.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class BookDto extends BaseDto{

    private Long id;

    private String name;

    private Date published;

    private String genre;

    private Integer rating;
}
