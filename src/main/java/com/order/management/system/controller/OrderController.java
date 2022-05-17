package com.order.management.system.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.order.management.system.model.OrderLine;
import com.order.management.system.service.CustomerService;
import com.order.management.system.service.OrderService;


	@Controller
	@RequestMapping("/api/order")
	public class OrderController {
		private static final Logger log = LoggerFactory.getLogger(OrderController.class);

		@Autowired
		OrderService orderService;
		
		@Autowired
		CustomerService customerService;


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
					return "customerOrder";
				}

			} catch (Exception e) {
				return e.getMessage();
			}

			
			return "index";
		}

		

		@RequestMapping(value = "/createOrder",  consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, method=RequestMethod.POST)
		public String createOrder(@RequestBody  MultiValueMap data) {
			
			try {
				log.info("OrderController.createOrder()");
				orderService.createOrder(data);
				return "Success";
			} catch (RuntimeException e) {
				return e.getMessage();
			}
		}
		
		
	}

