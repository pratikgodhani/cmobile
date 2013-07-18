package com.cognizant.cmobile.api.model;

public class BillingVO implements Comparable<BillingVO> {

	private long mobile;
	private String month;
	private long monthSeq;
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

	public long getMonthSeq() {
		return monthSeq;
	}

	public void setMonthSeq(long monthSeq) {
		this.monthSeq = monthSeq;
	}

	public int compareTo(BillingVO vo) {
		int val = -1;
		if (this.year == vo.getYear())
		{
			if (this.monthSeq == vo.getMonthSeq())
			{
				val = 0;
			}
			else if (this.monthSeq > vo.getMonthSeq())
			{
				val = 1;
			}
		}
		else if (this.year > vo.getYear())
		{
			val = 1;
		}
		return val;
	}
}
