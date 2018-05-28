package org.etspace.abc.vo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Product entity. @author MyEclipse Persistence Tools
 */

public class Product implements java.io.Serializable {

	// Fields

	private String productId;
	private String productName;
	private String productImg;
	private Date productDate;
	private Integer productSell;
	private Double productPrice;
	private String productDescription;
	private Integer productStorage;
	private String productParameter;
	private Short productType;
	private Set shoppingcarts = new HashSet(0);
	private Set orderProducts = new HashSet(0);

	// Constructors

	/** default constructor */
	public Product() {
	}

	/** minimal constructor */
	public Product(String productId, String productName, String productImg, Date productDate, Double productPrice,
			String productDescription, Integer productStorage, String productParameter, Short productType) {
		this.productId = productId;
		this.productName = productName;
		this.productImg = productImg;
		this.productDate = productDate;
		this.productPrice = productPrice;
		this.productDescription = productDescription;
		this.productStorage = productStorage;
		this.productParameter = productParameter;
		this.productType = productType;
	}

	/** full constructor */
	public Product(String productId, String productName, String productImg, Date productDate, Integer productSell,
			Double productPrice, String productDescription, Integer productStorage, String productParameter,
			Short productType, Set shoppingcarts, Set orderProducts) {
		this.productId = productId;
		this.productName = productName;
		this.productImg = productImg;
		this.productDate = productDate;
		this.productSell = productSell;
		this.productPrice = productPrice;
		this.productDescription = productDescription;
		this.productStorage = productStorage;
		this.productParameter = productParameter;
		this.productType = productType;
		this.shoppingcarts = shoppingcarts;
		this.orderProducts = orderProducts;
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

	public String getProductImg() {
		return this.productImg;
	}

	public void setProductImg(String productImg) {
		this.productImg = productImg;
	}

	public Date getProductDate() {
		return this.productDate;
	}

	public void setProductDate(Date productDate) {
		this.productDate = productDate;
	}

	public Integer getProductSell() {
		return this.productSell;
	}

	public void setProductSell(Integer productSell) {
		this.productSell = productSell;
	}

	public Double getProductPrice() {
		return this.productPrice;
	}

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductDescription() {
		return this.productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public Integer getProductStorage() {
		return this.productStorage;
	}

	public void setProductStorage(Integer productStorage) {
		this.productStorage = productStorage;
	}

	public String getProductParameter() {
		return this.productParameter;
	}

	public void setProductParameter(String productParameter) {
		this.productParameter = productParameter;
	}

	public Short getProductType() {
		return this.productType;
	}

	public void setProductType(Short productType) {
		this.productType = productType;
	}

	public Set getShoppingcarts() {
		return this.shoppingcarts;
	}

	public void setShoppingcarts(Set shoppingcarts) {
		this.shoppingcarts = shoppingcarts;
	}

	public Set getOrderProducts() {
		return this.orderProducts;
	}

	public void setOrderProducts(Set orderProducts) {
		this.orderProducts = orderProducts;
	}

}