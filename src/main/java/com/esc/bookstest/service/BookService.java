package com.esc.bookstest.service;

import com.esc.bookstest.dto.BookDto;

public interface BookService {
    BookDto createBook(BookDto bookDto);

    BookDto getBook(Long bookId);

    void deleteBook(Long bookId);

    BookDto updateBook(BookDto bookDto, Long bookId);

    Integer getNumberOfBooksByGenre(String genre);
}
