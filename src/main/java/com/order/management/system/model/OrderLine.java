package com.order.management.system.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Builder;
import lombok.Data;
@Entity


public class OrderLine {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="order_line_id")
	private Integer orderLineId;
	
	@Column(name="order_id")
	private Integer orderId;
	
	@Column(name="product_id")
	private Integer productId;
	
	@Column(name="quantity")
	private Integer quantity;
	
	@Column(name="price")
	private BigDecimal price;
	
	@Column(name="status")
	private String status;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(name="create_date")
	private Timestamp createDate;
	
	public OrderLine() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof OrderLine)) {
			return false;
		}
		OrderLine other = (OrderLine) obj;
		return Objects.equals(orderLineId, other.orderLineId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(orderLineId);
	}

	public Integer getOrderLineId() {
		return orderLineId;
	}

	public void setOrderLineId(Integer orderLineId) {
		this.orderLineId = orderLineId;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
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

	
	
	

}