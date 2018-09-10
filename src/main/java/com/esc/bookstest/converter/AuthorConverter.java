package com.esc.bookstest.converter;

import com.esc.bookstest.dto.AuthorDto;
import com.esc.bookstest.entity.Author;
import org.springframework.stereotype.Component;

@Component
public class AuthorConverter implements GenericConverter<AuthorDto, Author>{
    @Override
    public Author convertToEntity(AuthorDto dto) {
        return null;
    }

    @Override
    public AuthorDto convertToDto(Author entity) {
        return null;
    }
}
