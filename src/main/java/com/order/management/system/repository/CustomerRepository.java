package com.order.management.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.order.management.system.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
	 
}