package com.esc.bookstest.controller;

import com.esc.bookstest.dto.AuthorBookDto;
import com.esc.bookstest.exception.ResourceNotFoundException;
import com.esc.bookstest.service.AuthorBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/author_book")
public class AuthorBookController {

    @Autowired
    private AuthorBookService authorBookService;

    @PostMapping
    public ResponseEntity<AuthorBookDto> createRelation(@RequestBody AuthorBookDto authorBookDto) {
        return new ResponseEntity<>(authorBookService.createRelation(authorBookDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public AuthorBookDto getRelation(@PathVariable Long id) {
        return authorBookService.getRelation(id);
    }

    @DeleteMapping("/{id}")
    public void deleteRelation(@PathVariable Long id) {
        authorBookService.deleteRelation(id);
    }

    @PutMapping("/{id}")
    public AuthorBookDto updateRelation(@PathVariable Long id, @RequestBody AuthorBookDto authorBookDto) {
        return authorBookService.updateRelation(id, authorBookDto);
    }

    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity exceprionHandler(Exception e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
}
