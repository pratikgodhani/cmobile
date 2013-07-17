package org.cmobile.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cognizant.cmobile.api.model.FormResponse;
import com.cognizant.cmobile.api.model.PlanVO;
import com.cognizant.cmobile.api.service.PlanService;

@Controller
public class PlanController {

	@Autowired
	private PlanService planService;

	@RequestMapping("plans")
	public String getPlans(Model model) {
		FormResponse formResponse = new FormResponse();
		List<PlanVO> plans =  planService.getPlans();
		formResponse.setStatus("Pass");
		formResponse.setResult(plans);
		model.addAttribute("response", formResponse);
		return "plans";
	}
}
