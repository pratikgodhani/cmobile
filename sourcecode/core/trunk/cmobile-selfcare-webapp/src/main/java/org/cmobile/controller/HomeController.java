package org.cmobile.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.cmobile.api.model.CustomerVO;

@Controller
public class HomeController {

	@Autowired
	CustomerVO customerVO;
	
	@RequestMapping(value = "/home")
	public ModelAndView homePage(Model model)
			throws IOException {
		model.addAttribute("customer", customerVO);
		return new ModelAndView("home");
	}
}
