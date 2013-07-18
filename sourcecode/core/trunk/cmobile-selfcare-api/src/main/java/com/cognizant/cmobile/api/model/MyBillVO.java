package com.cognizant.cmobile.api.model;

import java.util.Date;

public class MyBillVO {

	private double lastBill;
	private Date lastBillDate;
	private Date lastBillDueDate;
	private Date lastPaymentDate;
	private double lastPayment;
	private double recentCharges;
	private Date nextBillDate;
	private boolean lastBillFlag;
	private boolean lastPaymentFlag;
	private boolean recentChargesFlag;
	private boolean makePaymentFlag;

	public double getLastBill() {
		return lastBill;
	}

	public void setLastBill(double lastBill) {
		this.lastBill = lastBill;
	}

	public Date getLastBillDate() {
		return lastBillDate;
	}

	public void setLastBillDate(Date lastBillDate) {
		this.lastBillDate = lastBillDate;
	}

	public Date getLastBillDueDate() {
		return lastBillDueDate;
	}

	public void setLastBillDueDate(Date lastBillDueDate) {
		this.lastBillDueDate = lastBillDueDate;
	}

	public Date getLastPaymentDate() {
		return lastPaymentDate;
	}

	public void setLastPaymentDate(Date lastPaymentDate) {
		this.lastPaymentDate = lastPaymentDate;
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

	public Date getNextBillDate() {
		return nextBillDate;
	}

	public void setNextBillDate(Date nextBillDate) {
		this.nextBillDate = nextBillDate;
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

	public boolean isRecentChargesFlag() {
		return recentChargesFlag;
	}

	public void setRecentChargesFlag(boolean recentChargesFlag) {
		this.recentChargesFlag = recentChargesFlag;
	}

	public boolean isMakePaymentFlag() {
		return makePaymentFlag;
	}

	public void setMakePaymentFlag(boolean makePaymentFlag) {
		this.makePaymentFlag = makePaymentFlag;
	}

}
