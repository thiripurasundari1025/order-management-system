package com.order.management.system.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "customer_id")
	private int customerId;

	@Column(name = "name")
	private String customerName;

	@Column(name = "address")
	private String customerAddress;

	@Column(name = "phone")
	private String customerPhoneNumber;

}
