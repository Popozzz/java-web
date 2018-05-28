package org.etspace.abc.vo;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * OrderDetails entity. @author MyEclipse Persistence Tools
 */

public class OrderDetails implements java.io.Serializable {

	// Fields

	private String orderId;
	private String customerId;
	private Double orderTotalAmount;
	private Timestamp orderDate;
	private Short orderState;
	private Short addressId;
	private String orderAddress;
	private Set orderProducts = new HashSet(0);

	// Constructors

	/** default constructor */
	public OrderDetails() {
	}

	/** minimal constructor */
	public OrderDetails(String orderId, String customerId, Double orderTotalAmount, Timestamp orderDate,
			Short orderState, Short addressId) {
		this.orderId = orderId;
		this.customerId = customerId;
		this.orderTotalAmount = orderTotalAmount;
		this.orderDate = orderDate;
		this.orderState = orderState;
		this.addressId = addressId;
	}

	/** full constructor */
	public OrderDetails(String orderId, String customerId, Double orderTotalAmount, Timestamp orderDate,
			Short orderState, Short addressId, String orderAddress, Set orderProducts) {
		this.orderId = orderId;
		this.customerId = customerId;
		this.orderTotalAmount = orderTotalAmount;
		this.orderDate = orderDate;
		this.orderState = orderState;
		this.addressId = addressId;
		this.orderAddress = orderAddress;
		this.orderProducts = orderProducts;
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

	public Set getOrderProducts() {
		return this.orderProducts;
	}

	public void setOrderProducts(Set orderProducts) {
		this.orderProducts = orderProducts;
	}

}