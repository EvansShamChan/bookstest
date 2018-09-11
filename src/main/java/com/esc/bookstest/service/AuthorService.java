package com.esc.bookstest.service;

import com.esc.bookstest.dto.AuthorDto;

import java.util.List;

public interface AuthorService {
    AuthorDto createAuthor(AuthorDto authorDto);

    AuthorDto getAuthor(Long authorId);

    void deleteAuthor(Long authorId);

    AuthorDto updateAuthor(Long authorId, AuthorDto authorDto);

    List<AuthorDto> getAllAuthorsOlderThan(Integer age);

    List<AuthorDto> getAllAuthorsByBookNumberGreaterThan(Integer bookNumber);

    List<AuthorDto> getAuthorsByMostBookNumber();
}
