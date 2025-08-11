package com.bashverse.rapidorderservice.repository;

import com.bashverse.rapidorderservice.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
