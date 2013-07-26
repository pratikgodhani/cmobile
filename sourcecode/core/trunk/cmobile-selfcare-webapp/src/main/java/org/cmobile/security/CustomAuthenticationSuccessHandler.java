package org.cmobile.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.cmobile.model.SessionCredential;
import org.cmobile.service.SessionCredentialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.cognizant.cmobile.api.model.CustomerVO;
import com.cognizant.cmobile.api.service.CustomerService;

@Component
public class CustomAuthenticationSuccessHandler extends
		SimpleUrlAuthenticationSuccessHandler {

	@Autowired
	SessionCredentialService sessionCredentialService;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		SessionCredential sessionCredential = sessionCredentialService.saveSessionCredential(authentication
				.getPrincipal().toString());
		Cookie cookie = new Cookie("CMOBILE_SELFCARE_USER", sessionCredential.getId().toString());
		response.addCookie(cookie);

		super.onAuthenticationSuccess(request, response, authentication);
	}
}
