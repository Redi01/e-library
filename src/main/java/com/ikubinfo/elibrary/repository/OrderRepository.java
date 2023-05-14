package com.ikubinfo.elibrary.repository;

import com.ikubinfo.elibrary.domain.entity.BorrowEntity;
import com.ikubinfo.elibrary.domain.entity.OrderUI;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderUI, Long> {

}
