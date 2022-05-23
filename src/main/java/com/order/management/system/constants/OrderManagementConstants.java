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
	public enum ProductPrize {
		Fressie_Orange_1_liter(0.5),Fressie_Orange_Mango_1_liter(0.52),Fressie_Orange_Cpower_PET(0.35),Fressie_Orange_PET(0.24),Fressie_Orange_Mango_PET(0.28),Fressie_Orange_Mango_C_1L(0.6);

		
		ProductPrize(Double prize) {
			this.setProductPrize(prize);
		}

		public Double getProductPrize() {
			return prize;
		}

		public void setProductPrize(Double prize) {
			this.prize = prize;
		}

		private Double prize;
	}

}
