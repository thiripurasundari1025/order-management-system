package com.order.management.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.management.system.model.Customer;
import com.order.management.system.repository.CustomerRepository;

@Service
public class CustomerService {

	
	@Autowired
	CustomerRepository customerRepository;

	
	
	
}
