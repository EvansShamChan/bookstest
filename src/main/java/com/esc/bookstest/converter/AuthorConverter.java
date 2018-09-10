package com.esc.bookstest.converter;

import com.esc.bookstest.dto.AuthorDto;
import com.esc.bookstest.entity.Author;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthorConverter implements GenericConverter<AuthorDto, Author>{

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Author convertToEntity(AuthorDto dto) {
        return modelMapper.map(dto, Author.class);
    }

    @Override
    public AuthorDto convertToDto(Author entity) {
        return modelMapper.map(entity, AuthorDto.class);
    }
}
