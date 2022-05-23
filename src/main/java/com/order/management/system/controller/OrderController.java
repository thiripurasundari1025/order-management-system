package com.order.management.system.controller;

import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.order.management.system.service.CustomerService;
import com.order.management.system.service.OrderService;


	@Controller
	@RequestMapping("/api/order")
	@SessionAttributes("customerName")
	public class OrderController {
		private static final Logger log = LoggerFactory.getLogger(OrderController.class);

		@Autowired
		OrderService orderService;
		
		@Autowired
		CustomerService customerService;

		

		@GetMapping("/login")
		public String showLogin() {
			log.info("OrderController.showLogin()");
			return "index";
		}

		@PostMapping("/login")
		public String login(@RequestParam Map<String, String> body,Model model) {
			try {
				log.info("OrderController.loginUser()");
				String customerName = body.getOrDefault("customerName", null);
				String password = body.getOrDefault("password", null);
				
				if (customerName.equals("alwaysBest") && password.equals("AlwaysBest")
						|| (customerName.equals("colmart") && password.equals("Colmart"))
						|| (customerName.equals("top") && password.equals("Top"))) {
					model.addAttribute( "customerName" , customerName); // before return statement
					return "customerOrder";
				}
				
			} catch (Exception e) {
				return e.getMessage();
			}

			
			return "index";
		}

		@RequestMapping(value = "/createOrder", method=RequestMethod.POST)
		public  String createOrder(@RequestBody MultiValueMap<String,String> data,Model model) {
			
			try {
				String customerName=model.getAttribute("customerName").toString();
				log.info("OrderController.createOrder()");
				
				String order= orderService.createOrder(data,customerName);
				
				if(order.equals("New order created scuccessfully.")) {
					model.addAttribute("message", "Order Created"); 
				}else {
					model.addAttribute("message", "Ordering failed.Try again!"); 
				}
				
				return "customerOrder";
			} catch (RuntimeException e) {
				return e.getMessage();
			}
		}
		
		
		
		
	}

