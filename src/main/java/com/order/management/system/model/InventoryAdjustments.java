package com.order.management.system.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
@Table(name = "inventory_adjustments")
public class InventoryAdjustments {



@Id
@Column(name = "inventory_adjustment_id")
private Integer invcentoryAdjustmentId;



@Column(name = "inventory_id")
private Integer inventoryId;



@Column(name = "adjustment_code")
private String adjustmentCode;



@Column(name = "adjustment_stock")
private BigDecimal adjustmentStock;



@Column(name = "create_date")
private Timestamp createDate;



}