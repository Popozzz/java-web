package org.etspace.abc.vo;

import java.sql.Timestamp;

/**
 * SumViewId entity. @author MyEclipse Persistence Tools
 */

public class SumViewId implements java.io.Serializable {

	// Fields

	private String productId;
	private String productName;
	private Double productPrice;
	private Integer productNumber;
	private Double productTotalAmount;
	private Timestamp orderDate;

	// Constructors

	/** default constructor */
	public SumViewId() {
	}

	/** full constructor */
	public SumViewId(String productId, String productName, Double productPrice, Integer productNumber,
			Double productTotalAmount, Timestamp orderDate) {
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productNumber = productNumber;
		this.productTotalAmount = productTotalAmount;
		this.orderDate = orderDate;
	}

	// Property accessors

	public String getProductId() {
		return this.productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getProductPrice() {
		return this.productPrice;
	}

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

	public Integer getProductNumber() {
		return this.productNumber;
	}

	public void setProductNumber(Integer productNumber) {
		this.productNumber = productNumber;
	}

	public Double getProductTotalAmount() {
		return this.productTotalAmount;
	}

	public void setProductTotalAmount(Double productTotalAmount) {
		this.productTotalAmount = productTotalAmount;
	}

	public Timestamp getOrderDate() {
		return this.orderDate;
	}

	public void setOrderDate(Timestamp orderDate) {
		this.orderDate = orderDate;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof SumViewId))
			return false;
		SumViewId castOther = (SumViewId) other;

		return ((this.getProductId() == castOther.getProductId()) || (this.getProductId() != null
				&& castOther.getProductId() != null && this.getProductId().equals(castOther.getProductId())))
				&& ((this.getProductName() == castOther.getProductName())
						|| (this.getProductName() != null && castOther.getProductName() != null
								&& this.getProductName().equals(castOther.getProductName())))
				&& ((this.getProductPrice() == castOther.getProductPrice())
						|| (this.getProductPrice() != null && castOther.getProductPrice() != null
								&& this.getProductPrice().equals(castOther.getProductPrice())))
				&& ((this.getProductNumber() == castOther.getProductNumber())
						|| (this.getProductNumber() != null && castOther.getProductNumber() != null
								&& this.getProductNumber().equals(castOther.getProductNumber())))
				&& ((this.getProductTotalAmount() == castOther.getProductTotalAmount())
						|| (this.getProductTotalAmount() != null && castOther.getProductTotalAmount() != null
								&& this.getProductTotalAmount().equals(castOther.getProductTotalAmount())))
				&& ((this.getOrderDate() == castOther.getOrderDate()) || (this.getOrderDate() != null
						&& castOther.getOrderDate() != null && this.getOrderDate().equals(castOther.getOrderDate())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getProductId() == null ? 0 : this.getProductId().hashCode());
		result = 37 * result + (getProductName() == null ? 0 : this.getProductName().hashCode());
		result = 37 * result + (getProductPrice() == null ? 0 : this.getProductPrice().hashCode());
		result = 37 * result + (getProductNumber() == null ? 0 : this.getProductNumber().hashCode());
		result = 37 * result + (getProductTotalAmount() == null ? 0 : this.getProductTotalAmount().hashCode());
		result = 37 * result + (getOrderDate() == null ? 0 : this.getOrderDate().hashCode());
		return result;
	}

}