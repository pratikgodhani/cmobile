package com.cognizant.cmobile.api.model;


public class BillingVO {

	private long mobile;
	private String month;
	private long year;
	private double billAmount;
	private long totalUsage;
	private double minutes;
	
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public long getYear() {
		return year;
	}
	public void setYear(long year) {
		this.year = year;
	}
	public double getBillAmount() {
		return billAmount;
	}
	public void setBillAmount(double billAmount) {
		this.billAmount = billAmount;
	}
	public long getTotalUsage() {
		return totalUsage;
	}
	public void setTotalUsage(long totalUsage) {
		this.totalUsage = totalUsage;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public double getMinutes() {
		return minutes;
	}
	public void setMinutes(double minutes) {
		this.minutes = minutes;
	}
}
