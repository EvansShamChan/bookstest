package com.esc.bookstest.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class AuthorDto extends BaseDto{

    private Long id;

    private String name;

    private String gender;

    private Date born;
}
