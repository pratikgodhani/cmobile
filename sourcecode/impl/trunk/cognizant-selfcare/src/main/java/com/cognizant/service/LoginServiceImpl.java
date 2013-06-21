package com.cognizant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.model.User;
import com.cognizant.repository.UserRepository;
import com.service.LoginService;

@Service("loginService")
public class LoginServiceImpl implements LoginService {

	@Autowired
	UserRepository userRepository;

	public boolean authenticateUserNamePassword(final String userName,
			final String password) {
		try {

			System.out.println("Gone into Cognizant Impl");
			User user = userRepository.findByUserNameAndPassword(userName,
					password);
			System.out.println("user.getId() :::::::::::: " + user.getId());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
