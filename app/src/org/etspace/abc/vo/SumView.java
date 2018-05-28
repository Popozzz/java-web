package org.etspace.abc.vo;

/**
 * SumView entity. @author MyEclipse Persistence Tools
 */

public class SumView implements java.io.Serializable {

	// Fields

	private SumViewId id;

	// Constructors

	/** default constructor */
	public SumView() {
	}

	/** full constructor */
	public SumView(SumViewId id) {
		this.id = id;
	}

	// Property accessors

	public SumViewId getId() {
		return this.id;
	}

	public void setId(SumViewId id) {
		this.id = id;
	}

}