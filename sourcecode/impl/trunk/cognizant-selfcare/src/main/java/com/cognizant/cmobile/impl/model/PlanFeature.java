package com.cognizant.cmobile.impl.model;

public class PlanFeature {
	private String name;
	private double rate;
	private String unit;
	private boolean visible;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	
	public String getDescription(){
		return this.rate + " " + this.unit;
	}
	
	@Override
	public String toString() {
		return this.rate + " " + this.unit;
	}

}
