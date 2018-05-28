package org.etspace.abc.vo;

/**
 * ShoppingcartId entity. @author MyEclipse Persistence Tools
 */

public class ShoppingcartId implements java.io.Serializable {

	// Fields

	private Customer customer;
	private Product product;

	// Constructors

	/** default constructor */
	public ShoppingcartId() {
	}

	/** full constructor */
	public ShoppingcartId(Customer customer, Product product) {
		this.customer = customer;
		this.product = product;
	}

	// Property accessors

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ShoppingcartId))
			return false;
		ShoppingcartId castOther = (ShoppingcartId) other;

		return ((this.getCustomer() == castOther.getCustomer()) || (this.getCustomer() != null
				&& castOther.getCustomer() != null && this.getCustomer().equals(castOther.getCustomer())))
				&& ((this.getProduct() == castOther.getProduct()) || (this.getProduct() != null
						&& castOther.getProduct() != null && this.getProduct().equals(castOther.getProduct())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getCustomer() == null ? 0 : this.getCustomer().hashCode());
		result = 37 * result + (getProduct() == null ? 0 : this.getProduct().hashCode());
		return result;
	}

}