package com.ikubinfo.elibrary.service.impl;

import com.ikubinfo.elibrary.domain.entity.BookEntity;
import com.ikubinfo.elibrary.domain.exception.BookNotFoundException;
import com.ikubinfo.elibrary.domain.exception.BookUnavailableException;
import com.ikubinfo.elibrary.repository.BookRepository;
import com.ikubinfo.elibrary.service.BookService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public List<BookEntity> getAllBooks() {
        return bookRepository.findAll();
    }

    public List<BookEntity> searchBooks(String query) {
        return bookRepository.findByTitleContainingIgnoreCase(query);
    }

    public BookEntity getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }


    public void returnBook(Long id) {
        BookEntity book = getBookById(id);
        if (book == null) {
            throw new BookNotFoundException("Book with id " + id + " not found");
        }
        book.setQuantity(book.getQuantity() + 1);
        bookRepository.save(book);
    }


    public void buyBook(Long id) {
        BookEntity book = getBookById(id);
        if (book == null) {
            throw new BookNotFoundException("Book with id " + id + " not found");
        }
        if (book.getQuantity() == 0) {
            throw new BookUnavailableException("Book with id " + id + " is currently unavailable");
        }
        book.setQuantity(book.getQuantity() - 1);
        bookRepository.save(book);
    }

    public void addBook(BookEntity book) {
        if (book == null) {
            throw new IllegalArgumentException("Book cannot be null");
        }
        bookRepository.save(book);
    }


    public void deleteBook(Long id) {
        BookEntity book = getBookById(id);
        if (book == null) {
            throw new BookNotFoundException("Book with id " + id + " not found");
        }
        bookRepository.deleteById(id);
    }

}
