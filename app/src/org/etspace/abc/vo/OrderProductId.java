package org.etspace.abc.vo;

/**
 * OrderProductId entity. @author MyEclipse Persistence Tools
 */

public class OrderProductId implements java.io.Serializable {

	// Fields

	private OrderDetails orderDetails;
	private String productId;

	// Constructors

	/** default constructor */
	public OrderProductId() {
	}

	/** full constructor */
	public OrderProductId(OrderDetails orderDetails, String productId) {
		this.orderDetails = orderDetails;
		this.productId = productId;
	}

	// Property accessors

	public OrderDetails getOrderDetails() {
		return this.orderDetails;
	}

	public void setOrderDetails(OrderDetails orderDetails) {
		this.orderDetails = orderDetails;
	}

	public String getProductId() {
		return this.productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof OrderProductId))
			return false;
		OrderProductId castOther = (OrderProductId) other;

		return ((this.getOrderDetails() == castOther.getOrderDetails()) || (this.getOrderDetails() != null
				&& castOther.getOrderDetails() != null && this.getOrderDetails().equals(castOther.getOrderDetails())))
				&& ((this.getProductId() == castOther.getProductId()) || (this.getProductId() != null
						&& castOther.getProductId() != null && this.getProductId().equals(castOther.getProductId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getOrderDetails() == null ? 0 : this.getOrderDetails().hashCode());
		result = 37 * result + (getProductId() == null ? 0 : this.getProductId().hashCode());
		return result;
	}

}