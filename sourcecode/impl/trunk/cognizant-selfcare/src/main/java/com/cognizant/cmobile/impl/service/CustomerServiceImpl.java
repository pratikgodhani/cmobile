package com.cognizant.cmobile.impl.service;

import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.cmobile.api.model.AccountDetailsVO;
import com.cognizant.cmobile.api.model.CustomerVO;
import com.cognizant.cmobile.api.service.CustomerService;
import com.cognizant.cmobile.impl.model.AccountDetails;
import com.cognizant.cmobile.impl.model.Customer;
import com.cognizant.cmobile.impl.repository.AccountDetailsRepository;
import com.cognizant.cmobile.impl.repository.CustomerRepository;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	AccountDetailsRepository accountDetailsRepository;

	@Autowired
	CustomerVO customerVO;

	public CustomerVO getCustomerByUserName(String userName) {
		Customer customer = customerRepository.findByUsername(userName);
		return convertPojoToVO(customer);
	}

	private CustomerVO convertPojoToVO(final Customer customer) {
		Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
		mapper.map(customer, customerVO);
		return customerVO;
	}

	public AccountDetailsVO getCustomerAccountDetails() {
		return convertPojoToVO(accountDetailsRepository
				.findByMobile(this.customerVO.getMobile()));
	}

	private AccountDetailsVO convertPojoToVO(final AccountDetails accountDetails) {
		Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
		return mapper.map(accountDetails, AccountDetailsVO.class);
	}

}
