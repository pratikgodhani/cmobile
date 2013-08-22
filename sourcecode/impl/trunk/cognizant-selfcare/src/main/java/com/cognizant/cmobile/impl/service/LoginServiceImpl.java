package com.cognizant.cmobile.impl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.cmobile.api.service.LoginService;
import com.cognizant.cmobile.impl.model.Customer;
import com.cognizant.cmobile.impl.repository.CustomerRepository;

@Service("loginService")
public class LoginServiceImpl implements LoginService {

	@Autowired
	CustomerRepository customerRepository;

	public boolean authenticate(final String userName,
			final String password) {
		Customer customer = customerRepository.findByUsernameAndPassword(
				userName, password);
		if (null != customer){
			return true;
		}
		return false;
	}


}
