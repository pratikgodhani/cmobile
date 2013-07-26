package com.cognizant.cmobile.api.model;


public class MyBillVO {

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

	private long minsPercentage;
	private long dataPercentage;

	private String minsProgressBarStyle;
	private String dataProgressBarStyle;

	private String currency;

	private static final String DEFAULT_PROGRESS_BAR_STYLE = "progress progress-striped active";

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

	public String getMinsProgressBarStyle() {
		minsPercentage = this.minutesUsed * 100 / this.totalMinutes;
		minsProgressBarStyle = DEFAULT_PROGRESS_BAR_STYLE + " progress-success";
		if (minsPercentage > 50 && minsPercentage <= 75) {
			minsProgressBarStyle = DEFAULT_PROGRESS_BAR_STYLE
					+ " progress-warning";
		} else if (minsPercentage > 75) {
			minsProgressBarStyle = DEFAULT_PROGRESS_BAR_STYLE
					+ " progress-danger";
		}
		return minsProgressBarStyle;
	}

	public String getDataProgressBarStyle() {
		dataPercentage = this.dataUsed * 100 / this.totalData;
		dataProgressBarStyle = DEFAULT_PROGRESS_BAR_STYLE + " progress-success";
		if (dataPercentage > 50 && dataPercentage <= 75) {
			dataProgressBarStyle = DEFAULT_PROGRESS_BAR_STYLE
					+ " progress-warning";
		} else if (dataPercentage > 75) {
			dataProgressBarStyle = DEFAULT_PROGRESS_BAR_STYLE
					+ " progress-danger";
		}
		return dataProgressBarStyle;
	}

	public long getMinsPercentage() {
		return minsPercentage;
	}

	public long getDataPercentage() {
		return dataPercentage;
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

}
