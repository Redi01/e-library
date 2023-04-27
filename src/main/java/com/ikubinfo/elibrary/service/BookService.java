package com.ikubinfo.elibrary.service;

import com.ikubinfo.elibrary.domain.entity.BookEntity;

import java.util.List;
public interface BookService {
    List<BookEntity> getAllBooks();
    List<BookEntity> searchBooks(String query);
    BookEntity getBookById(Long id);
    void returnBook(Long id);
    void buyBook(Long id);
    void addBook(BookEntity book);
    void deleteBook(Long id);
}
