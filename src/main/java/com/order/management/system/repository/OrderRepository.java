package com.order.management.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.order.management.system.model.OrderLine;
@Repository
public interface OrderRepository extends JpaRepository<OrderLine, Integer> {

}
