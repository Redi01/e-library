package com.ikubinfo.elibrary.repository;

import com.ikubinfo.elibrary.domain.entity.OrderBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderBookRepository extends JpaRepository<OrderBook,Long> {
}
