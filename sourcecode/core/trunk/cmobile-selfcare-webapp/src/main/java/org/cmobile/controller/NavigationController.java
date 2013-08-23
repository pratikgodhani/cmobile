package org.cmobile.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.cmobile.api.service.BillingService;

@Controller
public class NavigationController {
	
	@Autowired
	BillingService billingService;
	
	@Autowired
	Environment env;
	
	@RequestMapping(value = "/usageStatistics")
	public ModelAndView usageStatistics() {
		return new ModelAndView("usageStatistics");
	}
	
	@RequestMapping(value = "/billingHistoryChart")
	public ModelAndView billingHistoryChart() {
		return new ModelAndView("billingHistoryChart");
	}
	
	@RequestMapping(value = "/minuteDataUsageChart")
	public ModelAndView minuteDataUsageChart() {
		return new ModelAndView("minuteDataUsageChart");
	}
	
	@RequestMapping(value = "/myBillDetails")
	public ModelAndView myBillDetails(Model model) {
		model.addAttribute("myBillVO", billingService.getMyBillDetails());
		return new ModelAndView("myBillDetails");
	}
	
	@RequestMapping(value = "/feedback")
	public ModelAndView myFeedback(Model model) {
		String csurveyBaseURL = env.getProperty("csurvey.base.url");
		model.addAttribute("csurveyBaseURL", csurveyBaseURL);
		model.addAttribute("user", SecurityContextHolder.getContext().getAuthentication().getPrincipal());
		return new ModelAndView("feedback");
	}

}
