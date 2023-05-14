package com.ikubinfo.elibrary.controller;

import com.ikubinfo.elibrary.domain.dto.book.BookDTO;
import com.ikubinfo.elibrary.service.impl.BookServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
    @Autowired
    private BookServiceImpl bookService;
/*
    private final BorrowRepository borrowRepository;
*/

    @GetMapping("/getAllBooks")
    public List<BookDTO> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/search")
    public List<BookDTO> searchBooks(@RequestParam("query") String query) {
        return bookService.searchBooks(query);
    }

    @GetMapping("/{id}")
    public BookDTO getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @PostMapping("/returnBook/{id}")
    public void returnBook(@PathVariable Long id) {
        bookService.returnBook(id);
    }

    @PostMapping("/borrowBook/{id}")
    public void borrowBook(@PathVariable Long id,
                           @RequestParam("borrowerName") String borrowerName,
                           @RequestParam("borrowDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime borrowDate,
                           Authentication authentication) {

        String username = authentication.getName(); // Get the username of the authenticated user
        bookService.borrowBook(id, borrowerName, borrowDate, username);
    }

    @PostMapping("/addBook")
    public void addBook(@RequestBody BookDTO book) {
        bookService.addBook(book);
    }

    @DeleteMapping("/deleteBookById/{id}")
    public ResponseEntity<BookDTO> deleteBook(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.deleteBook(id));
    }

   /* @PostMapping("/check-unreturned-books")
    public List<BorrowEntity> checkUnreturnedBooks() {
        List <BorrowEntity> unreturnedBorrows = borrowRepository.findUnreturnedBorrows();
        return unreturnedBorrows;
    }*/
}


