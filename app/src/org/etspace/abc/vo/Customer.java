package org.etspace.abc.vo;

import java.util.HashSet;
import java.util.Set;

/**
 * Customer entity. @author MyEclipse Persistence Tools
 */

public class Customer implements java.io.Serializable {

	// Fields

	private String customerId;
	private String customerPassword;
	private String customerPhone;
	private String customerEmail;
	private Short customerSum;
	private Set shoppingcarts = new HashSet(0);
	private Set addresses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Customer() {
	}

	/** minimal constructor */
	public Customer(String customerId, String customerPassword, String customerPhone) {
		this.customerId = customerId;
		this.customerPassword = customerPassword;
		this.customerPhone = customerPhone;
	}

	/** full constructor */
	public Customer(String customerId, String customerPassword, String customerPhone, String customerEmail,
			Short customerSum, Set shoppingcarts, Set addresses) {
		this.customerId = customerId;
		this.customerPassword = customerPassword;
		this.customerPhone = customerPhone;
		this.customerEmail = customerEmail;
		this.customerSum = customerSum;
		this.shoppingcarts = shoppingcarts;
		this.addresses = addresses;
	}

	// Property accessors

	public String getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerPassword() {
		return this.customerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}

	public String getCustomerPhone() {
		return this.customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public String getCustomerEmail() {
		return this.customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public Short getCustomerSum() {
		return this.customerSum;
	}

	public void setCustomerSum(Short customerSum) {
		this.customerSum = customerSum;
	}

	public Set getShoppingcarts() {
		return this.shoppingcarts;
	}

	public void setShoppingcarts(Set shoppingcarts) {
		this.shoppingcarts = shoppingcarts;
	}

	public Set getAddresses() {
		return this.addresses;
	}

	public void setAddresses(Set addresses) {
		this.addresses = addresses;
	}
	

}