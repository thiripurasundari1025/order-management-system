package com.order.management.system.service;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import com.order.management.system.constants.OrderManagementConstants.CustomerInfo;
import com.order.management.system.constants.OrderManagementConstants.OrderHeaderStatus;
import com.order.management.system.model.Customer;
import com.order.management.system.model.OrderHeader;
import com.order.management.system.model.OrderLine;
import com.order.management.system.repository.CustomerRepository;
import com.order.management.system.repository.OrderHeaderRepository;
import com.order.management.system.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	OrderRepository orderRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	OrderHeaderRepository orderHeaderRepository;

	public String createOrder(MultiValueMap data) {
		System.out.println("order service");
		try {
		OrderLine orderData=new OrderLine();
		orderData.setProductId((Integer) data.get("product_id"));
		
		Customer customer = new Customer();
		
		OrderHeader header = new OrderHeader();

		if (customer.getCustomerName().equals("alwaysBest")) {
			header.setCustomerId(CustomerInfo.ALWAYS_BEST.getCustomerId());
		} else if (customer.getCustomerName().equals("colmart")) {
			header.setCustomerId(CustomerInfo.COLMART.getCustomerId());
		} else if (customer.getCustomerName().equals("top")) {
			header.setCustomerId(CustomerInfo.TOP.getCustomerId());
		}

		if (data != null) {
			//header.setDateId("#D11");
			orderHeaderRepository.save(header);
			OrderLine order = orderRepository.save(orderData);
			
			if(order!=null) {
				header.setDeliveryDate((Timestamp) data.get("delivery_date"));
				header.setQuantity((int) data.get("quantity"));
				header.setStatus(OrderHeaderStatus.CREDIT_CHECK_DONE.toString());
			}
			
			return "New order created scuccessfully.";
		}
		
	}catch(Exception e) {
		e.printStackTrace();
	}
		return "Invaild Data";
}
}

