package com.esc.bookstest.controller;

import com.esc.bookstest.dto.AuthorDto;
import com.esc.bookstest.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping
    public AuthorDto createAuthor(@RequestBody AuthorDto authorDto) {
        return authorService.createAuthor(authorDto);
    }

    @GetMapping("/{authorId}")
    public AuthorDto getAuthor(@PathVariable Long authorId) {
        return authorService.getAuthor(authorId);
    }

    @DeleteMapping("/{authorId}")
    public void deleteAuthor(@PathVariable Long authorId) {
        authorService.deleteAuthor(authorId);
    }

    @PutMapping("/{authorId}")
    public AuthorDto updateAuthor(@PathVariable Long authorId, @RequestBody AuthorDto authorDto) {
        return authorService.updateAuthor(authorId, authorDto);
    }

    // 2 task
    @GetMapping("/older/{age}")
    public List<AuthorDto> getAllAuthorsOlderThan(@PathVariable Integer age) {
        return authorService.getAllAuthorsOlderThan(age);
    }

    // 3 task
    @GetMapping("/bookNumber/{bookNumber}")
    public List<AuthorDto> getAllAuthorsByBookNumberGreaterThan(@PathVariable Integer bookNumber) {
        return authorService.getAllAuthorsByBookNumberGreaterThan(bookNumber);
    }

    // 4 task
    @GetMapping("/bookNumber/most")
    public List<AuthorDto> getAuthorByMostBookNumber() {
        return authorService.getAuthorsByMostBookNumber();
    }
}
