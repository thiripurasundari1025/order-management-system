package com.order.management.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.order.management.system.model.Product;

public interface ProductRepository extends JpaRepository<Product,Integer> {
 
}