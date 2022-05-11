package com.order.management.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.order.management.system.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
	 
}