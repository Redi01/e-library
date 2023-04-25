package com.ikubinfo.elibrary.service.impl;

import com.ikubinfo.elibrary.domain.entity.BookEntity;
import com.ikubinfo.elibrary.repository.BookRepository;
import com.ikubinfo.elibrary.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<BookEntity> getAllBooks() {
        return bookRepository.findAll();
    }

    public List<BookEntity> searchBooks(String query) {
        return bookRepository.findByTitleContainingIgnoreCase(query);
    }

    public BookEntity getBookById(Long id) {
        return (BookEntity) bookRepository.findById(id).orElse(null);
    }

    public void borrowBook(Long id) {
        BookEntity book = getBookById(id);
        if (book != null && book.getQuantity() > 0) {
            book.setQuantity(book.getQuantity() - 1);
            bookRepository.save(book);
        }
    }

    public void returnBook(Long id) {
        BookEntity book = getBookById(id);
        if (book != null) {
            book.setQuantity(book.getQuantity() + 1);
            bookRepository.save(book);
        }
    }

    public void buyBook(Long id) {
        BookEntity book = getBookById(id);
        if (book != null && book.getQuantity() > 0) {
            book.setQuantity(book.getQuantity() - 1);
            bookRepository.save(book);
        }
    }

    public void addBook(BookEntity book) {
        bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

}
