package com.cognizant.cmobile.impl.service;

import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.cmobile.api.model.CustomerVO;
import com.cognizant.cmobile.api.service.CustomerService;
import com.cognizant.cmobile.impl.model.Customer;
import com.cognizant.cmobile.impl.repository.CustomerRepository;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
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

}
