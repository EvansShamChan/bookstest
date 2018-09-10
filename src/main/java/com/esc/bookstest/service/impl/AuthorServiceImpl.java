package com.esc.bookstest.service.impl;

import com.esc.bookstest.converter.AuthorConverter;
import com.esc.bookstest.dto.AuthorDto;
import com.esc.bookstest.entity.Author;
import com.esc.bookstest.exception.ResourceNotFoundException;
import com.esc.bookstest.repository.AuthorRepository;
import com.esc.bookstest.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorConverter authorConverter;

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public AuthorDto createAuthor(AuthorDto authorDto) {
        Author author = authorConverter.convertToEntity(authorDto);
        authorRepository.save(author);
        return authorConverter.convertToDto(author);
    }

    @Override
    public AuthorDto getAuthor(Long authorId) {
        Author author = authorRepository.findById(authorId).orElseThrow(
                () -> new ResourceNotFoundException(String.format("Author with id %d not found", authorId)));
        return authorConverter.convertToDto(author);
    }

    @Override
    public void deleteAuthor(Long authorId) {
        authorRepository.deleteById(authorId);
    }

    @Override
    public AuthorDto updateAuthor(Long authorId, AuthorDto authorDto) {
        // check if author exists
        authorRepository.findById(authorId).orElseThrow(
                () -> new ResourceNotFoundException(String.format("Author with id %d not found", authorId)));

        Author author = authorConverter.convertToEntity(authorDto);
        author.setId(authorId);
        authorRepository.save(author);
        return authorConverter.convertToDto(author);
    }
}
