package com.esc.bookstest.converter;

import com.esc.bookstest.dto.AuthorBookDto;
import com.esc.bookstest.entity.AuthorBook;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthorBookConverter implements GenericConverter<AuthorBookDto, AuthorBook>{

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public AuthorBook convertToEntity(AuthorBookDto dto) {
        return modelMapper.map(dto, AuthorBook.class);
    }

    @Override
    public AuthorBookDto convertToDto(AuthorBook entity) {
        return modelMapper.map(entity, AuthorBookDto.class);
    }
}
