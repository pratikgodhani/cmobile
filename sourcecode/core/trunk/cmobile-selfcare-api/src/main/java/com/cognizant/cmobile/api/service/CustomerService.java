package com.cognizant.cmobile.api.service;

import com.cognizant.cmobile.api.model.AccountDetailsVO;
import com.cognizant.cmobile.api.model.CustomerVO;

public interface CustomerService {

	CustomerVO getCustomerByUserName(final String userName);
	
	AccountDetailsVO getCustomerAccountDetails();
}
