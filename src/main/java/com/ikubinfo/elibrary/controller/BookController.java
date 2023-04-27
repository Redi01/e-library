package com.ikubinfo.elibrary.controller;

import com.ikubinfo.elibrary.domain.entity.BookEntity;
import com.ikubinfo.elibrary.service.impl.BookServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
    @Autowired
    private BookServiceImpl bookService;

    @GetMapping("/")
    public List<BookEntity> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/search")
    public List<BookEntity> searchBooks(@RequestParam("query") String query) {
        return bookService.searchBooks(query);
    }

    @GetMapping("/{id}")
    public BookEntity getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @PostMapping("/{id}/borrow")
    public void borrowBook(@PathVariable Long id) {
        bookService.borrowBook(id);
    }

    @PostMapping("/{id}/return")
    public void returnBook(@PathVariable Long id) {
        bookService.returnBook(id);
    }

    @PostMapping("/{id}/buy")
    public void buyBook(@PathVariable Long id) {
        bookService.buyBook(id);
    }

    @PostMapping("/")
    public void addBook(@RequestBody BookEntity book) {
        bookService.addBook(book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }
}


