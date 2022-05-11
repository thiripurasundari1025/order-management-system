package com.order.management.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.management.system.model.OrderLine;
import com.order.management.system.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	OrderRepository orderRepository;

	public String createOrder(OrderLine orderLine) {
		if (orderLine != null) {
			orderRepository.save(orderLine);
			return "New order created scuccessfully.";
		}
		return "Invaild Data";
	}

}
