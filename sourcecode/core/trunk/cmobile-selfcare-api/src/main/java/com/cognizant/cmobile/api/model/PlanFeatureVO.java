package com.cognizant.cmobile.api.model;

/**
 * Defines feature of a plan
 * @author cts1
 *
 */
public class PlanFeatureVO {

	private String name;
	private String description;
	private boolean visible;

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isVisible() {
		return visible;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

}
