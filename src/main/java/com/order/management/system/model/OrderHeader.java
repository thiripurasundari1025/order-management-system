package com.order.management.system.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="order_header")
public class OrderHeader {
 
    @Id
    @Column(name="order_id")
    private int orderId;

    @Column(name="customer_id")
    private int customerId;

    @Column(name="quantity")
    private int quantity;

    @Column(name="status")
    private String status;

    @Column(name="create_date")
    private Timestamp createDate;

    @Column(name="delivery_date")
    private Timestamp deliveryDate;

    @Column(name="total_price")
    private Double totalPrice;

    @Column(name="date_id")
    private String dateId;

}