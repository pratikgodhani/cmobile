package org.cmobile.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.cmobile.api.service.OtherNetworkConsumerService;

@Controller
public class OtherNetworkConsumerController {

	@Autowired
	OtherNetworkConsumerService otherNetworkConsumerService;
	
	@RequestMapping(value = "/otherNetworkConsumers")
	public ModelAndView otherNetworkConsumers(Model model) throws Exception {
		model.addAttribute("otherNetworkConsumerVO",otherNetworkConsumerService.getOtherNetworkConsumers());
		model.addAttribute("offerForInvitor",otherNetworkConsumerService.getOffersForInvitor());
		model.addAttribute("offerForInvitee",otherNetworkConsumerService.getOffersForInvitee());
		return new ModelAndView("otherNetworkConsumers");
	}	
}
