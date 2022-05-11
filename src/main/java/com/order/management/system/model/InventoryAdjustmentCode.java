package com.order.management.system.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
@Table(name = "inventory_adjustment_code")
public class InventoryAdjustmentCode {
	@Id
	@Column(name = "code_id")
	private Integer codeId;
	@Column(name = "code")
	private String code;
	@Column(name = "description")
	private String description;
}
