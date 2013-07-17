package com.cognizant.cmobile.api.service;

import java.util.List;

import com.cognizant.cmobile.api.model.PlanVO;

public interface PlanService {
	/**
	 * Returns available plans for customer. The customer details will be picked
	 * up from session by the implementation
	 * 
	 * @return PlanVO
	 */
	List<PlanVO> getPlans();
	
}
