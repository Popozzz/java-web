package org.etspace.abc.vo;

import java.sql.Timestamp;

/**
 * OrderViewId entity. @author MyEclipse Persistence Tools
 */

public class OrderViewId implements java.io.Serializable {

	// Fields

	private String orderId;
	private String customerId;
	private Double orderTotalAmount;
	private Timestamp orderDate;
	private Short orderState;
	private Short addressId;
	private String orderAddress;
	private String productId;
	private Integer productNumber;
	private Double productPrice;
	private String productName;
	private String productImg;

	// Constructors

	/** default constructor */
	public OrderViewId() {
	}

	/** minimal constructor */
	public OrderViewId(String orderId, String customerId, Double orderTotalAmount, Timestamp orderDate,
			Short orderState, Short addressId, String productId, Integer productNumber, Double productPrice,
			String productName, String productImg) {
		this.orderId = orderId;
		this.customerId = customerId;
		this.orderTotalAmount = orderTotalAmount;
		this.orderDate = orderDate;
		this.orderState = orderState;
		this.addressId = addressId;
		this.productId = productId;
		this.productNumber = productNumber;
		this.productPrice = productPrice;
		this.productName = productName;
		this.productImg = productImg;
	}

	/** full constructor */
	public OrderViewId(String orderId, String customerId, Double orderTotalAmount, Timestamp orderDate,
			Short orderState, Short addressId, String orderAddress, String productId, Integer productNumber,
			Double productPrice, String productName, String productImg) {
		this.orderId = orderId;
		this.customerId = customerId;
		this.orderTotalAmount = orderTotalAmount;
		this.orderDate = orderDate;
		this.orderState = orderState;
		this.addressId = addressId;
		this.orderAddress = orderAddress;
		this.productId = productId;
		this.productNumber = productNumber;
		this.productPrice = productPrice;
		this.productName = productName;
		this.productImg = productImg;
	}

	// Property accessors

	public String getOrderId() {
		return this.orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public Double getOrderTotalAmount() {
		return this.orderTotalAmount;
	}

	public void setOrderTotalAmount(Double orderTotalAmount) {
		this.orderTotalAmount = orderTotalAmount;
	}

	public Timestamp getOrderDate() {
		return this.orderDate;
	}

	public void setOrderDate(Timestamp orderDate) {
		this.orderDate = orderDate;
	}

	public Short getOrderState() {
		return this.orderState;
	}

	public void setOrderState(Short orderState) {
		this.orderState = orderState;
	}

	public Short getAddressId() {
		return this.addressId;
	}

	public void setAddressId(Short addressId) {
		this.addressId = addressId;
	}

	public String getOrderAddress() {
		return this.orderAddress;
	}

	public void setOrderAddress(String orderAddress) {
		this.orderAddress = orderAddress;
	}

	public String getProductId() {
		return this.productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public Integer getProductNumber() {
		return this.productNumber;
	}

	public void setProductNumber(Integer productNumber) {
		this.productNumber = productNumber;
	}

	public Double getProductPrice() {
		return this.productPrice;
	}

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductImg() {
		return this.productImg;
	}

	public void setProductImg(String productImg) {
		this.productImg = productImg;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof OrderViewId))
			return false;
		OrderViewId castOther = (OrderViewId) other;

		return ((this.getOrderId() == castOther.getOrderId()) || (this.getOrderId() != null
				&& castOther.getOrderId() != null && this.getOrderId().equals(castOther.getOrderId())))
				&& ((this.getCustomerId() == castOther.getCustomerId()) || (this.getCustomerId() != null
						&& castOther.getCustomerId() != null && this.getCustomerId().equals(castOther.getCustomerId())))
				&& ((this.getOrderTotalAmount() == castOther.getOrderTotalAmount())
						|| (this.getOrderTotalAmount() != null && castOther.getOrderTotalAmount() != null
								&& this.getOrderTotalAmount().equals(castOther.getOrderTotalAmount())))
				&& ((this.getOrderDate() == castOther.getOrderDate()) || (this.getOrderDate() != null
						&& castOther.getOrderDate() != null && this.getOrderDate().equals(castOther.getOrderDate())))
				&& ((this.getOrderState() == castOther.getOrderState()) || (this.getOrderState() != null
						&& castOther.getOrderState() != null && this.getOrderState().equals(castOther.getOrderState())))
				&& ((this.getAddressId() == castOther.getAddressId()) || (this.getAddressId() != null
						&& castOther.getAddressId() != null && this.getAddressId().equals(castOther.getAddressId())))
				&& ((this.getOrderAddress() == castOther.getOrderAddress())
						|| (this.getOrderAddress() != null && castOther.getOrderAddress() != null
								&& this.getOrderAddress().equals(castOther.getOrderAddress())))
				&& ((this.getProductId() == castOther.getProductId()) || (this.getProductId() != null
						&& castOther.getProductId() != null && this.getProductId().equals(castOther.getProductId())))
				&& ((this.getProductNumber() == castOther.getProductNumber())
						|| (this.getProductNumber() != null && castOther.getProductNumber() != null
								&& this.getProductNumber().equals(castOther.getProductNumber())))
				&& ((this.getProductPrice() == castOther.getProductPrice())
						|| (this.getProductPrice() != null && castOther.getProductPrice() != null
								&& this.getProductPrice().equals(castOther.getProductPrice())))
				&& ((this.getProductName() == castOther.getProductName())
						|| (this.getProductName() != null && castOther.getProductName() != null
								&& this.getProductName().equals(castOther.getProductName())))
				&& ((this.getProductImg() == castOther.getProductImg())
						|| (this.getProductImg() != null && castOther.getProductImg() != null
								&& this.getProductImg().equals(castOther.getProductImg())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getOrderId() == null ? 0 : this.getOrderId().hashCode());
		result = 37 * result + (getCustomerId() == null ? 0 : this.getCustomerId().hashCode());
		result = 37 * result + (getOrderTotalAmount() == null ? 0 : this.getOrderTotalAmount().hashCode());
		result = 37 * result + (getOrderDate() == null ? 0 : this.getOrderDate().hashCode());
		result = 37 * result + (getOrderState() == null ? 0 : this.getOrderState().hashCode());
		result = 37 * result + (getAddressId() == null ? 0 : this.getAddressId().hashCode());
		result = 37 * result + (getOrderAddress() == null ? 0 : this.getOrderAddress().hashCode());
		result = 37 * result + (getProductId() == null ? 0 : this.getProductId().hashCode());
		result = 37 * result + (getProductNumber() == null ? 0 : this.getProductNumber().hashCode());
		result = 37 * result + (getProductPrice() == null ? 0 : this.getProductPrice().hashCode());
		result = 37 * result + (getProductName() == null ? 0 : this.getProductName().hashCode());
		result = 37 * result + (getProductImg() == null ? 0 : this.getProductImg().hashCode());
		return result;
	}

}