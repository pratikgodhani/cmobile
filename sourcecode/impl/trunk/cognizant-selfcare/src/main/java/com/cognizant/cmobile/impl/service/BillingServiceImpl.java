package com.cognizant.cmobile.impl.service;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.cmobile.api.model.BillingVO;
import com.cognizant.cmobile.api.model.CustomerVO;
import com.cognizant.cmobile.api.service.BillingService;
import com.cognizant.cmobile.impl.model.Billing;
import com.cognizant.cmobile.impl.repository.BillingRepository;

@Service("billingService")
public class BillingServiceImpl implements BillingService {

	@Autowired
	BillingRepository billingRepository;
	
	@Autowired
	CustomerVO customerVO;
	
	public List<BillingVO> getBillingHistory() {
		List<Billing> billingList = billingRepository.findByMobile(customerVO.getMobile());
		return convertPojoToVOs(billingList);
	}

	private BillingVO convertPojoToVO(final Billing billing) {
		Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
		return (mapper.map(billing, BillingVO.class));
	}
	
	private List<BillingVO> convertPojoToVOs(final List<Billing> billings) {
		List<BillingVO> convertedBillingList = new ArrayList<BillingVO>();
		for (Billing billing : billings){
			convertedBillingList.add(convertPojoToVO(billing));
		}
		return convertedBillingList;
	}
}
