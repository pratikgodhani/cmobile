package org.cmobile.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class LoginController {
	@RequestMapping("/login")
	public ModelAndView login(Model model, HttpServletRequest request) {
		if (null != request.getParameter("error") && request.getParameter("error").equals("1"))
		{
			model.addAttribute("errorMsg", "Either entered Username/Password is wrong. Try again....");
			model.addAttribute("showErrorMsg", Boolean.TRUE);
		}
		return new ModelAndView("login");
	}
}
