package org.cmobile.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NavigationController {
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

}
