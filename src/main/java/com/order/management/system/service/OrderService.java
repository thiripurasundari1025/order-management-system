package com.order.management.system.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

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
import com.order.management.system.utils.CollectionUtils;

@Service
public class OrderService {

	@Autowired
	OrderRepository orderRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	OrderHeaderRepository orderHeaderRepository;

	// @Slf4j
	public String createOrder(MultiValueMap<String, String> data, String customerName) {
		try {
			OrderLine orderData = new OrderLine();
			orderData.setProductId(Integer.valueOf(CollectionUtils.getFromList(data.get("product_id"))));

			Customer customer = new Customer();

			OrderHeader header = new OrderHeader();

			if (customerName.equals("alwaysBest")) {
				header.setCustomerId(CustomerInfo.ALWAYS_BEST.getCustomerId());
			} else if (customerName.equals("colmart")) {
				header.setCustomerId(CustomerInfo.COLMART.getCustomerId());
			} else if (customerName.equals("top")) {
				header.setCustomerId(CustomerInfo.TOP.getCustomerId());
			}

			if (data != null) {
				// header.setDateId("#D11");
				OrderHeader headerDate= orderHeaderRepository.save(header);
				OrderLine order = orderRepository.save(orderData);

				if (order != null) {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
				    String DateToStoreInDataBase= sdf.format(new Date()); // java.util.Date
				    System.out.println(DateToStoreInDataBase);

				    Timestamp ts = Timestamp.valueOf(DateToStoreInDataBase); // java.sql.Timestamp
				  
				    headerDate.setDeliveryDate(ts);
				    headerDate.setQuantity(Integer.valueOf(CollectionUtils.getFromList(data.get("quantity"))));
				    headerDate.setStatus(OrderHeaderStatus.CREDIT_CHECK_DONE.toString());
				    orderHeaderRepository.save(headerDate);
				}

				return "New order created scuccessfully.";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Invaild Data";
	}
}
