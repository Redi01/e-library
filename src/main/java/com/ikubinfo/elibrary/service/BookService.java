package com.ikubinfo.elibrary.service;

import com.ikubinfo.elibrary.domain.dto.book.BookDTO;
import java.time.LocalDate;
import java.util.List;
public interface BookService {
    List<BookDTO> getAllBooks();
    List<BookDTO> searchBooks(String query);
    BookDTO getBookById(Long id);
    void returnBook(Long id);
    public void borrowBook(Long id, String borrowerName, LocalDate borrowDate, String username);
    void addBook(BookDTO book);
    BookDTO deleteBook(Long id);

}
