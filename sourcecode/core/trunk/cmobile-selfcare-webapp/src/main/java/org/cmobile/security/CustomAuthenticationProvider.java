package org.cmobile.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.cognizant.cmobile.api.service.LoginService;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	@Qualifier("loginService")
	LoginService loginService;

	@Override
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
		boolean authenticated = loginService.authenticate(authentication
				.getPrincipal().toString(), authentication.getCredentials()
				.toString());
		if (authenticated) {
			/*
			 * return new UsernamePasswordAuthenticationToken(customerVO,
			 * authentication.getCredentials(), new
			 * ArrayList<GrantedAuthority>());
			 */
			return new UsernamePasswordAuthenticationToken(
					authentication.getPrincipal(), null, null);
		}

		return null;
	}

	@Override
	public boolean supports(Class<?> arg0) {
		return true;
	}
}
