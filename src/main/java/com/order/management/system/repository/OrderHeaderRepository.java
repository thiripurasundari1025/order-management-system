package com.order.management.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.order.management.system.model.OrderHeader;

public interface OrderHeaderRepository extends JpaRepository<OrderHeader,Integer> {
 
}