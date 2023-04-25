package com.ikubinfo.elibrary.repository;

import com.ikubinfo.elibrary.domain.dto.order.OrderDTO;
import com.ikubinfo.elibrary.domain.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
