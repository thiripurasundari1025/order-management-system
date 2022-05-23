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
import com.order.management.system.constants.OrderManagementConstants.OrderLineStatus;
import com.order.management.system.constants.OrderManagementConstants.ProductPrize;
import com.order.management.system.model.Customer;
import com.order.management.system.model.OrderHeader;
import com.order.management.system.model.OrderLine;
import com.order.management.system.model.Product;
import com.order.management.system.repository.CustomerRepository;
import com.order.management.system.repository.OrderHeaderRepository;
import com.order.management.system.repository.OrderRepository;
import com.order.management.system.repository.ProductRepository;
import com.order.management.system.utils.CollectionUtils;
import com.order.management.system.utils.DateUtil;

@Service
public class OrderService {
	Integer productId,quantity;
	String DateToStoreInDataBase;
	String status;
	
	Timestamp deliveryDate;
	@Autowired
	OrderRepository orderRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	OrderHeaderRepository orderHeaderRepository;

	@Autowired
	ProductRepository productRepository;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
	
	// @Slf4j
	public String createOrder(MultiValueMap<String, String> data, String customerName) {

		try {
			
			if (data != null) {
				 productId = Integer.valueOf(CollectionUtils.getFromList(data.get("product_id")));
				 quantity = Integer.valueOf(CollectionUtils.getFromList(data.get("quantity")));
				 DateToStoreInDataBase = sdf.format(DateUtil.convertStringToDate(CollectionUtils.getFromList(data.get("delivery_date")), "yyyy-MM-dd")); // java.util.Date
				 deliveryDate = Timestamp.valueOf(DateToStoreInDataBase); // java.sql.Timestamp
				 status = OrderLineStatus.CREDIT_CHECK_DONE.toString();
			}
                //create Order Header
				OrderHeader header = new OrderHeader();
				header=createOrderHeader(header,customerName);
				
				Product product = productRepository.getById(productId);
				Double prize = product.getSalesPriceRetail();
				
			    //create Order Line
				OrderLine orderData = new OrderLine();
				
				orderData.setProductId(productId);
				orderData.setStatus(status);
				orderData.setQuantity(quantity);
				orderData.setPrice(quantity * prize);
				orderData.setOrderId(header.getOrderId());
				OrderLine order = orderRepository.save(orderData);

				if (order != null) {
					 //update OrderHeader once OrderLine created
					header.setDeliveryDate(deliveryDate);
					header.setQuantity(orderData.getQuantity());
					header.setTotalPrice(orderData.getPrice());
					header.setStatus(OrderHeaderStatus.CREDIT_CHECK_DONE.toString());
					orderHeaderRepository.save(header);
				}

				return "New order created scuccessfully.";
			

		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return "Invaild Data";
	}

	private OrderHeader createOrderHeader(OrderHeader header, String customerName) {
		
		if (customerName.equals("alwaysBest")) {
			header.setCustomerId(CustomerInfo.ALWAYS_BEST.getCustomerId());
		} else if (customerName.equals("colmart")) {
			header.setCustomerId(CustomerInfo.COLMART.getCustomerId());
		} else if (customerName.equals("top")) {
			header.setCustomerId(CustomerInfo.TOP.getCustomerId());
		}
       // header.setDateId("#D11");
		return  orderHeaderRepository.save(header);
	}
}
