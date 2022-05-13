package com.order.management.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.order.management.system.model.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
 
}