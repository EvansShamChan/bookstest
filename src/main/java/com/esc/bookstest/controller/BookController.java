package com.esc.bookstest.controller;

import com.esc.bookstest.dto.BookDto;
import com.esc.bookstest.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public BookDto createBook(@RequestBody BookDto bookDto) {
        return bookService.createBook(bookDto);
    }

    @GetMapping("/{bookId}")
    public BookDto getBook(@PathVariable Long bookId) {
        return bookService.getBook(bookId);
    }

    @DeleteMapping("/{bookId}")
    public void deleteBook(@PathVariable Long bookId) {
        bookService.deleteBook(bookId);
    }

    @PutMapping("/{bookId}")
    public BookDto updateBook(@RequestBody BookDto bookDto, @PathVariable Long bookId) {
        return bookService.updateBook(bookDto, bookId);
    }

    @GetMapping("/genre/{genre}")
    public Integer getNumberOfBooksByGenre(@PathVariable String genre) {
        return bookService.getNumberOfBooksByGenre(genre);
    }
}
