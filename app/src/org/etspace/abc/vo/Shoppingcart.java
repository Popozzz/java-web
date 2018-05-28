package org.etspace.abc.vo;

/**
 * Shoppingcart entity. @author MyEclipse Persistence Tools
 */

public class Shoppingcart implements java.io.Serializable {

	// Fields

	private ShoppingcartId id;
	private Integer productNumber;
	private String productImg;
	private String productName;
	private Double productPrice;

	// Constructors

	/** default constructor */
	public Shoppingcart() {
	}

	/** full constructor */
	public Shoppingcart(ShoppingcartId id, Integer productNumber, String productImg, String productName,
			Double productPrice) {
		this.id = id;
		this.productNumber = productNumber;
		this.productImg = productImg;
		this.productName = productName;
		this.productPrice = productPrice;
	}

	// Property accessors

	public ShoppingcartId getId() {
		return this.id;
	}

	public void setId(ShoppingcartId id) {
		this.id = id;
	}

	public Integer getProductNumber() {
		return this.productNumber;
	}

	public void setProductNumber(Integer productNumber) {
		this.productNumber = productNumber;
	}

	public String getProductImg() {
		return this.productImg;
	}

	public void setProductImg(String productImg) {
		this.productImg = productImg;
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

}