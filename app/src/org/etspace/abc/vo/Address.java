package org.etspace.abc.vo;

/**
 * Address entity. @author MyEclipse Persistence Tools
 */

public class Address implements java.io.Serializable {

	// Fields

	private AddressId id;
	private String customerName;
	private String customerAddress;
	private String customerPhone;

	// Constructors

	/** default constructor */
	public Address() {
	}

	/** full constructor */
	public Address(AddressId id, String customerName, String customerAddress, String customerPhone) {
		this.id = id;
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.customerPhone = customerPhone;
	}

	// Property accessors

	public AddressId getId() {
		return this.id;
	}

	public void setId(AddressId id) {
		this.id = id;
	}

	public String getCustomerName() {
		return this.customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerAddress() {
		return this.customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCustomerPhone() {
		return this.customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

}