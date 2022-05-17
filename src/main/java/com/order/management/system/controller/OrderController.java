package com.order.management.system.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.order.management.system.service.OrderService;


	@Controller
	@RequestMapping("/api/order")
	public class OrderController {
		private static final Logger log = LoggerFactory.getLogger(OrderController.class);

		@Autowired
		OrderService orderService;

		@GetMapping("/index")
		public String showLogin() {
			log.info("OrderController.showLogin()");
			return "index";
		}

		@PostMapping("/login")
		public String login(@RequestParam Map<String, String> body) {
			try {
				log.info("OrderController.loginUser()");
				String customerName = body.getOrDefault("customerName", null);
				String password = body.getOrDefault("password", null);

				if (customerName.equals("f&g") && password.equals("f&g")
						|| (customerName.equals("domnic") && password.equals("domnic"))
						|| (customerName.equals("landmark") && password.equals("landmark"))) {
					return "customer-order";
				}

			} catch (Exception e) {
				return e.getMessage();
			}

			
			return "index";
		}

		@PostMapping("create")
		public String createOrder(@RequestParam Map<String, String> body) {
			try {
				log.info("OrderController.createOrder()");

				return "Success";
			} catch (RuntimeException e) {
				return e.getMessage();
			}
		}
	}

