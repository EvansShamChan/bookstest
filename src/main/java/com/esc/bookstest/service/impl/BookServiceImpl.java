package com.esc.bookstest.service.impl;

import com.esc.bookstest.converter.BookConverter;
import com.esc.bookstest.dto.BookDto;
import com.esc.bookstest.entity.Book;
import com.esc.bookstest.exception.ResourceNotFoundException;
import com.esc.bookstest.repository.BookRepository;
import com.esc.bookstest.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookConverter bookConverter;

    @Autowired
    private BookRepository bookRepository;

    @Override
    public BookDto createBook(BookDto bookDto) {
        Book book = bookConverter.convertToEntity(bookDto);
        bookRepository.save(book);
        return bookConverter.convertToDto(book);
    }

    @Override
    public BookDto getBook(Long bookId) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Book with id %d not found", bookId)));
        return bookConverter.convertToDto(book);
    }

    @Override
    public void deleteBook(Long bookId) {
        bookRepository.deleteById(bookId);
    }

    @Override
    public BookDto updateBook(BookDto bookDto, Long bookId) {
        // check if book exists
        bookRepository.findById(bookId)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Book with id %d not found", bookId)));

        Book book = bookConverter.convertToEntity(bookDto);
        book.setId(bookId);
        bookRepository.save(book);
        return bookConverter.convertToDto(book);
    }

    @Override
    public Integer getNumberOfBooksByGenre(String genre) {
        return bookRepository.getNumberOfBooksByGenre(genre);
    }
}
