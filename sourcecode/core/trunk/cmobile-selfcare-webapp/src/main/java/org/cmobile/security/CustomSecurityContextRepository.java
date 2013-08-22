package org.cmobile.security;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.cmobile.model.SessionCredential;
import org.cmobile.service.SessionCredentialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpRequestResponseHolder;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.stereotype.Component;

import com.cognizant.cmobile.api.service.CustomerService;

@Component
public class CustomSecurityContextRepository implements
		SecurityContextRepository {

	@Autowired
	SessionCredentialService credentialService;

	@Autowired
	CustomerService customerService;
	
	@Autowired
	Environment env;
	
	@Override
	public SecurityContext loadContext(
			HttpRequestResponseHolder requestResponseHolder) {
		Cookie[] cookies = requestResponseHolder.getRequest().getCookies();
		String objectId = null;
		if (null != cookies) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("CMOBILE_SELFCARE_USER")) {
					objectId = cookie.getValue();
					break;
				}
			}
		}
		if (null != objectId) {
			SecurityContext securityContext = SecurityContextHolder
					.createEmptyContext();
			SessionCredential sessionCredential = credentialService
					.getSessionCredentialByObjectId(objectId);
			if (null != sessionCredential) {
				String authEnabled =  env.getProperty("auth_enabled");
				if(null != authEnabled && authEnabled.equalsIgnoreCase("true")){
					customerService.getCustomerByUserName(sessionCredential.getUsername());
				}else{
					//If authentication is not enabled, then load an existing dummy user
					customerService.getCustomerByUserName("admin");
				}
				
				Authentication authentication = new UsernamePasswordAuthenticationToken(
						sessionCredential.getUsername(), null, null);
				securityContext.setAuthentication(authentication);
			}
			return securityContext;
		} else {
			return SecurityContextHolder.createEmptyContext();
		}

	}

	@Override
	public void saveContext(SecurityContext context,
			HttpServletRequest request, HttpServletResponse response) {
	}

	@Override
	public boolean containsContext(HttpServletRequest request) {

		return true;
	}

}
