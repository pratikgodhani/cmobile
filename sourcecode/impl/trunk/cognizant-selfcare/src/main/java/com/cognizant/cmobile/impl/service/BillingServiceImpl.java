package com.cognizant.cmobile.impl.service;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.cmobile.api.model.BillingVO;
import com.cognizant.cmobile.api.model.CustomerVO;
import com.cognizant.cmobile.api.model.MyBillVO;
import com.cognizant.cmobile.api.service.BillingService;
import com.cognizant.cmobile.impl.model.Billing;
import com.cognizant.cmobile.impl.model.MyBill;
import com.cognizant.cmobile.impl.repository.BillingRepository;
import com.cognizant.cmobile.impl.repository.MyBillRepository;

@Service("billingService")
public class BillingServiceImpl implements BillingService {

	@Autowired
	BillingRepository billingRepository;

	@Autowired
	MyBillRepository myBillRepository;

	@Autowired
	CustomerVO customerVO;

	public List<BillingVO> getBillingHistory() {
		List<Billing> billingList = billingRepository.findByMobile(customerVO
				.getMobile());
		List<BillingVO> convertedBillingList = convertPojoToVOs(billingList);
		Collections.sort(convertedBillingList);
		int startingIndex = 0;
		if (convertedBillingList.size() - 11 > 0) {
			startingIndex = convertedBillingList.size() - 11;
		}
		return convertedBillingList.subList(startingIndex,
				convertedBillingList.size());
	}

	private BillingVO convertPojoToVO(final Billing billing) {
		Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
		return (mapper.map(billing, BillingVO.class));
	}

	private List<BillingVO> convertPojoToVOs(final List<Billing> billings) {
		List<BillingVO> convertedBillingList = new ArrayList<BillingVO>();
		for (Billing billing : billings) {
			convertedBillingList.add(convertPojoToVO(billing));
		}
		return convertedBillingList;
	}

	public MyBillVO getMyBillDetails() {
		MyBillVO myBillVO = convertPojoToVO(myBillRepository
				.findByMobile(customerVO.getMobile()));
		myBillVO.setCurrency("£");
		return myBillVO;
	}

	private MyBillVO convertPojoToVO(final MyBill myBill) {
		Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
		return (mapper.map(myBill, MyBillVO.class));
	}

	public InputStream getItemisedMonthlyBill(String month, long year)
			throws FileNotFoundException {

		InputStream inputStream = Thread
				.currentThread()
				.getContextClassLoader()
				.getResourceAsStream(
						"pdfFiles/MobileBill_" + month + "_" + year + ".pdf");
		return inputStream;
	}

}
