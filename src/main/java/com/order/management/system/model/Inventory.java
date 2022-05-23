package com.order.management.system.model;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
@Table(name = "inventory")
public class Inventory {
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO)
	@Column(name = "item_id")
	private Integer itemId;
	
	@Column(name = "manufactured_date_id")
	private String manufactureDateId;
	
	@Column(name = "product_id")
	private Integer productId;
	
	@Column(name = "stock")
	private Integer stock;
	
	@Column(name = "stock_source_description")
	private String stockSourceDescription;
	
	@Column(name = "back_order_sum")
	private Integer backOrderSum;
	
	@Column(name = "reserved_stock")
	private Integer reservedStock;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "create_date")
	private Timestamp createDate;
}
