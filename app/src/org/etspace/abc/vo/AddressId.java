package org.etspace.abc.vo;

/**
 * AddressId entity. @author MyEclipse Persistence Tools
 */

public class AddressId implements java.io.Serializable {

	// Fields

	private Customer customer;
	private Short addressId;

	// Constructors

	/** default constructor */
	public AddressId() {
	}

	/** full constructor */
	public AddressId(Customer customer, Short addressId) {
		this.customer = customer;
		this.addressId = addressId;
	}

	// Property accessors

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Short getAddressId() {
		return this.addressId;
	}

	public void setAddressId(Short addressId) {
		this.addressId = addressId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof AddressId))
			return false;
		AddressId castOther = (AddressId) other;

		return ((this.getCustomer() == castOther.getCustomer()) || (this.getCustomer() != null
				&& castOther.getCustomer() != null && this.getCustomer().equals(castOther.getCustomer())))
				&& ((this.getAddressId() == castOther.getAddressId()) || (this.getAddressId() != null
						&& castOther.getAddressId() != null && this.getAddressId().equals(castOther.getAddressId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getCustomer() == null ? 0 : this.getCustomer().hashCode());
		result = 37 * result + (getAddressId() == null ? 0 : this.getAddressId().hashCode());
		return result;
	}

}