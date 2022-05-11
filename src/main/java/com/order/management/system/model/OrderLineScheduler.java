package com.order.management.system.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="order_line_schedule")
public class OrderLineScheduler {
 
    @Id
    @Column(name="id")
    private int id;

    @Column(name="date_id")
    private String dateId;

    @Column(name="order_line_id")
    private int orderlineId;

    @Column(name="warehouse_location")
    private String warehouseLocation;

    @Column(name="warehouse_id")
    private int warehouseId;
 
}