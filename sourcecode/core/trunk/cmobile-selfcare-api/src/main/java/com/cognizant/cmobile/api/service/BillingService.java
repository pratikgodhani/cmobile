package com.cognizant.cmobile.api.service;

import java.util.List;

import com.cognizant.cmobile.api.model.BillingVO;

public interface BillingService {

	List<BillingVO> getBillingHistory();
}
