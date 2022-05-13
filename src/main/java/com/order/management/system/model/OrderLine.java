package com.order.management.system.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Data;
@Entity
@Data
@Builder
public class OrderLine {
	@SuppressWarnings("unused")
	@Id
	private Integer orderLineId;
	@SuppressWarnings("unused")
	private Integer orderId;
	@SuppressWarnings("unused")
	private Integer productId;
	@SuppressWarnings("unused")
	private Integer quantity;
	@SuppressWarnings("unused")
	private BigDecimal price;
	@SuppressWarnings("unused")
	private String status;
	@SuppressWarnings("unused")
	private Timestamp createDate;

}