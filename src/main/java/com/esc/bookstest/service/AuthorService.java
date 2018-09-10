package com.esc.bookstest.service;

import com.esc.bookstest.dto.AuthorDto;

public interface AuthorService {
    AuthorDto createAuthor(AuthorDto authorDto);

    AuthorDto getAuthor(Long authorId);

    void deleteAuthor(Long authorId);

    AuthorDto updateAuthor(Long authorId, AuthorDto authorDto);
}
