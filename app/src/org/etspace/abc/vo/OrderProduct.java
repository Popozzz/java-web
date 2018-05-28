package org.etspace.abc.vo;

/**
 * OrderProduct entity. @author MyEclipse Persistence Tools
 */

public class OrderProduct implements java.io.Serializable {

	// Fields

	private OrderProductId id;
	private Integer productNumber;
	private Double productPrice;
	private String productName;
	private String productImg;

	// Constructors

	/** default constructor */
	public OrderProduct() {
	}

	/** full constructor */
	public OrderProduct(OrderProductId id, Integer productNumber, Double productPrice, String productName,
			String productImg) {
		this.id = id;
		this.productNumber = productNumber;
		this.productPrice = productPrice;
		this.productName = productName;
		this.productImg = productImg;
	}

	// Property accessors

	public OrderProductId getId() {
		return this.id;
	}

	public void setId(OrderProductId id) {
		this.id = id;
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

}