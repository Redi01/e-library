package com.ikubinfo.elibrary.service.impl;

import com.ikubinfo.elibrary.domain.dto.book.BookDTO;
import com.ikubinfo.elibrary.domain.entity.BookEntity;
import com.ikubinfo.elibrary.domain.exception.BookNotFoundException;
import com.ikubinfo.elibrary.domain.exception.BookUnavailableException;
import com.ikubinfo.elibrary.domain.exception.ResourceNotFoundException;
import com.ikubinfo.elibrary.domain.mapper.BookMapper;
import com.ikubinfo.elibrary.repository.BookRepository;
import com.ikubinfo.elibrary.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
@Autowired
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    public List<BookDTO> getAllBooks() {
        List<BookEntity> bookEntities = bookRepository.findAll();
        return bookMapper.toDtoList(bookEntities);
    }

    public List<BookDTO> searchBooks(String query) {
        List<BookEntity> bookEntities = bookRepository.findByTitleContainingIgnoreCase(query);
        return bookMapper.toDtoList(bookEntities);
    }

    public BookDTO getBookById(Long id) {
        BookEntity bookEntity = bookRepository.findById(id).orElse(null);
        if (bookEntity == null) {
            throw new BookNotFoundException("Book with id " + id + " not found");
        }
        return bookMapper.toDto(bookEntity);
    }

    public void returnBook(Long id) {
        BookEntity bookEntity = bookRepository.findById(id).orElse(null);
        if (bookEntity == null) {
            throw new BookNotFoundException("Book with id " + id + " not found");
        }
        bookEntity.setBorrowerName("");
        bookEntity.setBorrowDate(null);
        bookEntity.setQuantity(bookEntity.getQuantity() + 1);
        bookRepository.save(bookEntity);
    }

    @Override
    public void borrowBook(Long id, String borrowerName, LocalDate borrowDate, String username) {

        BookEntity bookEntity = bookRepository.findById(id).get();
        if (bookEntity == null) {
            throw new BookNotFoundException("Book with id " + id + " not found");
        }
        if (bookEntity.getQuantity() == 0) {
            throw new BookUnavailableException("Book with id " + id + " is currently unavailable to borrow");
        }

        bookEntity.setQuantity(bookEntity.getQuantity() - 1);
        bookEntity.setBorrowerName(borrowerName);
        bookEntity.setBorrowDate(borrowDate);


        bookRepository.save(bookEntity);
    }
    public void addBook(BookDTO bookDTO) {
        if (bookDTO == null) {
            throw new IllegalArgumentException("Book cannot be null");
        }
        BookEntity bookEntity = bookMapper.toEntity(bookDTO);
        bookRepository.save(bookEntity);
    }

    public BookDTO deleteBook(Long id) {
        Optional<BookEntity> bookEntity = bookRepository.findById(id);
        if (bookEntity.isPresent()) {
            bookRepository.deleteById(id);
            return bookMapper.toDto(bookEntity.get());
        }else {
            throw new ResourceNotFoundException("Book with id " + id + " not found");
        }
    }

    }






