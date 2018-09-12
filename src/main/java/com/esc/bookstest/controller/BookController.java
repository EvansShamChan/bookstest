package com.esc.bookstest.controller;

import com.esc.bookstest.dto.BookDto;
import com.esc.bookstest.exception.ResourceNotFoundException;
import com.esc.bookstest.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public ResponseEntity<BookDto> createBook(@RequestBody BookDto bookDto) {
        return new ResponseEntity<>(bookService.createBook(bookDto), HttpStatus.CREATED);
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

    // 5 task
    @GetMapping("/genre/{genre}")
    public Integer getNumberOfBooksByGenre(@PathVariable String genre) {
        return bookService.getNumberOfBooksByGenre(genre);
    }

    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity exceprionHandler(Exception e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
}
