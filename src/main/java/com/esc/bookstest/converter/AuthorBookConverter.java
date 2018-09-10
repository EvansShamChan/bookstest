package com.esc.bookstest.converter;

import com.esc.bookstest.dto.AuthorBookDto;
import com.esc.bookstest.entity.AuthorBook;
import org.springframework.stereotype.Component;

@Component
public class AuthorBookConverter implements GenericConverter<AuthorBookDto, AuthorBook>{
    @Override
    public AuthorBook convertToEntity(AuthorBookDto dto) {
        return null;
    }

    @Override
    public AuthorBookDto convertToDto(AuthorBook entity) {
        return null;
    }
}
