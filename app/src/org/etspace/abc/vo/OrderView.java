package org.etspace.abc.vo;

/**
 * OrderView entity. @author MyEclipse Persistence Tools
 */

public class OrderView implements java.io.Serializable {

	// Fields

	private OrderViewId id;

	// Constructors

	/** default constructor */
	public OrderView() {
	}

	/** full constructor */
	public OrderView(OrderViewId id) {
		this.id = id;
	}

	// Property accessors

	public OrderViewId getId() {
		return this.id;
	}

	public void setId(OrderViewId id) {
		this.id = id;
	}

}