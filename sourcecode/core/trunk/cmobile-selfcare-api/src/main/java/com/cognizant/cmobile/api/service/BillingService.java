package com.cognizant.cmobile.api.service;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

import com.cognizant.cmobile.api.model.BillingVO;
import com.cognizant.cmobile.api.model.MyBillVO;

public interface BillingService {

	List<BillingVO> getBillingHistory();

	MyBillVO getMyBillDetails();

	InputStream getItemisedMonthlyBill(final String month, final long year)
			throws FileNotFoundException;
}
