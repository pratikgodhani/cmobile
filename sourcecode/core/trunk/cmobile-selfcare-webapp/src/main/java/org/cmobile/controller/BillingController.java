package org.cmobile.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cognizant.cmobile.api.model.FormResponse;
import com.cognizant.cmobile.api.service.BillingService;

@Controller
public class BillingController {

	@Autowired
	BillingService billingService;
	
	@RequestMapping(value = "/billingHistoryData")
	public @ResponseBody FormResponse billingHistoryData() throws Exception {
		FormResponse formResponse = new FormResponse();
		formResponse.setStatus("Pass");
		formResponse.setResult(billingService.getBillingHistory());
		return formResponse;
	}
	
	@RequestMapping(value = "/minuteDataUsageData")
	public @ResponseBody FormResponse minuteDataUsageData() throws Exception {
		FormResponse formResponse = new FormResponse();
		formResponse.setStatus("Pass");
		formResponse.setResult(billingService.getBillingHistory());
		return formResponse;
	}
}
