package com.ikubinfo.elibrary.service;

import com.ikubinfo.elibrary.domain.dto.book.BookDTO;
import com.ikubinfo.elibrary.domain.entity.BookEntity;
import org.springframework.security.core.Authentication;

import java.time.LocalDateTime;
import java.util.List;
public interface BookService {
    List<BookDTO> getAllBooks();
    List<BookDTO> searchBooks(String query);
    BookDTO getBookById(Long id);
    void returnBook(Long id);
    public void borrowBook(Long id, String borrowerName, LocalDateTime borrowDate, String username);
    void addBook(BookDTO book);
    BookDTO deleteBook(Long id);

/*
    void checkUnreturnedBooks();
*/
}
