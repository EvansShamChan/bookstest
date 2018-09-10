package com.esc.bookstest.converter;

import com.esc.bookstest.dto.BookDto;
import com.esc.bookstest.entity.Book;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookConverter implements GenericConverter<BookDto, Book>{

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Book convertToEntity(BookDto dto) {
        return modelMapper.map(dto, Book.class);
    }

    @Override
    public BookDto convertToDto(Book entity) {
        return modelMapper.map(entity, BookDto.class);
    }
}
