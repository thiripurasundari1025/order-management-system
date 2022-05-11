package com.order.management.system.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.management.system.model.OrderLine;
import com.order.management.system.service.OrderService;

@RestController
@RequestMapping("/api/order")
public class OrderController {
	private static final Logger log = LoggerFactory.getLogger(OrderController.class);

	@Autowired 
	OrderService orderService;

	@PostMapping("create")
	public String createOrder(@RequestBody OrderLine orderLine) {
	try {
		return orderService.createOrder(orderLine);
	} catch (RuntimeException e) {
		return e.getMessage();
	}
}
}
