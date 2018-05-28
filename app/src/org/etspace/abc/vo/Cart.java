package org.etspace.abc.vo;

public class Cart {
	
	private String customerId;
	private String productId;
	private Integer productNumber;
	private String productImg;
	private String productName;
	private Double productPrice;
	
	public Cart()
	{
		
	}
	
	public Cart(String customerId,String productId, Integer productNumber, String productImg, String productName,
			Double productPrice)
	{
		this.customerId = customerId;
		this.productId = productId;
		this.productNumber = productNumber;
		this.productImg = productImg;
		this.productName = productName;
		this.productPrice = productPrice;
	}
	
	public String getCustomerId()
	{
		return this.customerId;
	}
	
	public void setCustomerId(String customerId)
	{
		this.customerId = customerId;
	}
	
	public String getProoductId()
	{
		return this.productId;
	}
	
	public void setProductId(String productId)
	{
		this.productId = productId;
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
