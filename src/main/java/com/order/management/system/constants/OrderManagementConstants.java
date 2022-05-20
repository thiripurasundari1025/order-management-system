package com.order.management.system.constants;

public class OrderManagementConstants {

	public enum OrderLineStatus {
		CREDIT_CHECK_DONE, RESERVED, DELIVERED, BACK_ORDER, CREATED, CONFIRMED, ON_HOLD, ALLOCATED,
		RELEASED_FOR_PICKING, SHIPPED, INVOICED, PAYMENT_RECEIVED
	}

	public enum OrderHeaderStatus {
		CREDIT_CHECK_DONE, RESERVED, DELIVERED, BACK_ORDER, CREATED, CONFIRMED, ON_HOLD, ALLOCATED,
		RELEASED_FOR_PICKING, SHIPPED, INVOICED, PAYMENT_RECEIVED
	}

	public enum InventoryStatus {
		QUALITY, ALLOCATED, OBSOLETE, LEAKAGE, IN_TRANSIT, DISCONTINUED
	}

	public enum CustomerInfo {
		ALWAYS_BEST(603), TOP(609), COLMART(606);

		CustomerInfo(int customerId) {
			this.setCustomerId(customerId);
		}

		public Integer getCustomerId() {
			return customerId;
		}

		public void setCustomerId(Integer customerId) {
			this.customerId = customerId;
		}

		private Integer customerId;
	}

}
