package com.ikubinfo.elibrary.repository;

import com.ikubinfo.elibrary.domain.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {
    Optional<BookEntity> findById(Long id);
    List<BookEntity> findByTitleContainingIgnoreCase(String title);
}
