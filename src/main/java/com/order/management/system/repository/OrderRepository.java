package com.order.management.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.order.management.system.model.OrderLine;

public interface OrderRepository extends JpaRepository<OrderLine, Integer> {

}
