package com.esc.bookstest.service.impl;

import com.esc.bookstest.converter.AuthorBookConverter;
import com.esc.bookstest.dto.AuthorBookDto;
import com.esc.bookstest.entity.AuthorBook;
import com.esc.bookstest.exception.ResourceNotFoundException;
import com.esc.bookstest.repository.AuthorBookRepository;
import com.esc.bookstest.service.AuthorBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorBookServiceImpl implements AuthorBookService {

    @Autowired
    private AuthorBookConverter authorBookConverter;

    @Autowired
    private AuthorBookRepository authorBookRepository;

    @Override
    public AuthorBookDto createRelation(AuthorBookDto authorBookDto) {
        AuthorBook authorBook = authorBookConverter.convertToEntity(authorBookDto);
        authorBookRepository.save(authorBook);
        return authorBookConverter.convertToDto(authorBook);
    }

    @Override
    public AuthorBookDto getRelation(Long id) {
        AuthorBook authorBook = authorBookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Relation with id %d not found", id)));
        return authorBookConverter.convertToDto(authorBook);
    }

    @Override
    public void deleteRelation(Long id) {
        authorBookRepository.deleteById(id);
    }

    @Override
    public AuthorBookDto updateRelation(Long id, AuthorBookDto authorBookDto) {
        // check if relation exists
        authorBookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Relation with id %d not found", id)));

        AuthorBook authorBook = authorBookConverter.convertToEntity(authorBookDto);
        authorBook.setId(id);
        authorBookRepository.save(authorBook);
        return authorBookConverter.convertToDto(authorBook);
    }
}
