package com.order.management.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.order.management.system.model.OrderLineScheduler;

public interface OrderLineSchedulerRepository extends JpaRepository<OrderLineScheduler,Integer> {
 
}