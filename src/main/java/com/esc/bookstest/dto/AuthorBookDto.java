package com.esc.bookstest.dto;

import lombok.Data;

@Data
public class AuthorBookDto extends BaseDto{

    private Long id;

    private Long author_id;

    private Long book_id;
}
