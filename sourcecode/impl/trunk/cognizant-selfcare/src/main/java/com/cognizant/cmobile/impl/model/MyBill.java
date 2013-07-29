package com.cognizant.cmobile.impl.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "myBill")
public class MyBill {

	@Id
	private ObjectId id;
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

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

}
