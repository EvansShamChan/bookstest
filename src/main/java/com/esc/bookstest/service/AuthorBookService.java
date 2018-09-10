package com.esc.bookstest.service;

import com.esc.bookstest.dto.AuthorBookDto;

public interface AuthorBookService {
    AuthorBookDto createRelation(AuthorBookDto authorBookDto);

    AuthorBookDto getRelation(Long id);

    void deleteRelation(Long id);

    AuthorBookDto updateRelation(Long id, AuthorBookDto authorBookDto);
}
