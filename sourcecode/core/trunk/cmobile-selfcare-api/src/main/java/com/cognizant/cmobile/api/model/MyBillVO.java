package com.cognizant.cmobile.api.model;

public class MyBillVO {

	private long mobile;

	private double lastBill;
	private String lastBillDate;
	private String lastBillDueDate;
	private String lastPaymentDate;
	private double lastPayment;
	private double recentCharges;
	private String nextBillDate;
	private boolean lastBillFlag;
	private boolean lastPaymentFlag;
	private boolean makePaymentFlag;
	private boolean dataUsageFlag;
	private long minutesUsed;
	private long totalMinutes;
	private long dataUsed;
	private long totalData;
	private String currency;

	// Chart Related Properties....
	private long[] minsRanges = new long[2];
	private long[] dataRanges = new long[2];

	private int dataLabelStep = 2;
	private int minutesLabelStep = 2;

	public double getLastBill() {
		return lastBill;
	}

	public void setLastBill(double lastBill) {
		this.lastBill = lastBill;
	}

	public double getLastPayment() {
		return lastPayment;
	}

	public void setLastPayment(double lastPayment) {
		this.lastPayment = lastPayment;
	}

	public double getRecentCharges() {
		return recentCharges;
	}

	public void setRecentCharges(double recentCharges) {
		this.recentCharges = recentCharges;
	}

	public boolean isLastBillFlag() {
		return lastBillFlag;
	}

	public void setLastBillFlag(boolean lastBillFlag) {
		this.lastBillFlag = lastBillFlag;
	}

	public boolean isLastPaymentFlag() {
		return lastPaymentFlag;
	}

	public void setLastPaymentFlag(boolean lastPaymentFlag) {
		this.lastPaymentFlag = lastPaymentFlag;
	}

	public boolean isMakePaymentFlag() {
		return makePaymentFlag;
	}

	public void setMakePaymentFlag(boolean makePaymentFlag) {
		this.makePaymentFlag = makePaymentFlag;
	}

	public boolean isDataUsageFlag() {
		return dataUsageFlag;
	}

	public void setDataUsageFlag(boolean dataUsageFlag) {
		this.dataUsageFlag = dataUsageFlag;
	}

	public long getTotalMinutes() {
		return totalMinutes;
	}

	public void setTotalMinutes(long totalMinutes) {
		this.totalMinutes = totalMinutes;
	}

	public long getTotalData() {
		return totalData;
	}

	public void setTotalData(long totalData) {
		this.totalData = totalData;
	}

	public long getMinutesUsed() {
		return minutesUsed;
	}

	public void setMinutesUsed(long minutesUsed) {
		this.minutesUsed = minutesUsed;
	}

	public long getDataUsed() {
		return dataUsed;
	}

	public void setDataUsed(long dataUsed) {
		this.dataUsed = dataUsed;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getLastBillDate() {
		return lastBillDate;
	}

	public void setLastBillDate(String lastBillDate) {
		this.lastBillDate = lastBillDate;
	}

	public String getLastBillDueDate() {
		return lastBillDueDate;
	}

	public void setLastBillDueDate(String lastBillDueDate) {
		this.lastBillDueDate = lastBillDueDate;
	}

	public String getLastPaymentDate() {
		return lastPaymentDate;
	}

	public void setLastPaymentDate(String lastPaymentDate) {
		this.lastPaymentDate = lastPaymentDate;
	}

	public String getNextBillDate() {
		return nextBillDate;
	}

	public void setNextBillDate(String nextBillDate) {
		this.nextBillDate = nextBillDate;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public long[] getMinsRanges() {
		minsRanges[0] = (totalMinutes * 50) / 100;
		minsRanges[1] = minsRanges[0]
				+ ((totalMinutes - minsRanges[0]) * 50 / 100);
		return minsRanges;
	}

	public long[] getDataRanges() {
		dataRanges[0] = (totalData * 50) / 100;
		dataRanges[1] = dataRanges[0]
				+ ((totalData - dataRanges[0]) * 50 / 100);
		return dataRanges;
	}

	public int getDataLabelStep() {
		if (this.totalData >= 1000) {
			this.dataLabelStep = 4;
		}
		return dataLabelStep;
	}

	public int getMinutesLabelStep() {
		if (this.totalMinutes >= 1000) {
			this.minutesLabelStep = 4;
		}
		return minutesLabelStep;
	}

}
