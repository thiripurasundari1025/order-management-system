package com.order.management.system.model;

import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;



@Entity
@Table(name="order_header")
public class OrderHeader {
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="order_id")
    private int orderId;

    @Column(name="customer_id")
    private int customerId;

    @Column(name="quantity")
    @Min(value = 0)
    private int quantity;

    @Column(name="status")
    private String status;
    
    
    @Column(name="create_date")
    @CreationTimestamp
    private Timestamp createDate;

   // @FutureOrPresent(message = "creation date must be future or present.")
    @Column(name="delivery_date")
    private Timestamp deliveryDate;

    @Column(name="total_price")
    private Double totalPrice;

//    @Column(name="date_id")
//    private String dateId;

    
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public Timestamp getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Timestamp deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

//	public String getDateId() {
//		return dateId;
//	}
//
//	public void setDateId(String dateId) {
//		this.dateId = dateId;
//	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof OrderHeader)) {
			return false;
		}
		OrderHeader other = (OrderHeader) obj;
		return orderId == other.orderId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(orderId);
	}

}