package com.cognizant.cmobile.impl.service;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.cmobile.api.model.CustomerVO;
import com.cognizant.cmobile.api.model.PlanVO;
import com.cognizant.cmobile.api.service.PlanService;
import com.cognizant.cmobile.impl.model.Plan;
import com.cognizant.cmobile.impl.repository.PlanRepository;

@Service("planService")
public class PlanServiceImpl implements PlanService {

	@Autowired
	private PlanRepository planRepository;

	@Autowired
	CustomerVO customerVO;

	public List<PlanVO> getPlans() {
		List<Plan> plans = planRepository.findByMobile(customerVO.getMobile());
		return convertPojoToVOs(plans);
	}

	private List<PlanVO> convertPojoToVOs(final List<Plan> plans) {
		List<PlanVO> planVOs = new ArrayList<PlanVO>();
		for (Plan plan : plans) {
			PlanVO planVO = new PlanVO();
			Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
			mapper.map(plan, planVO);
			planVOs.add(planVO);
		}
		return planVOs;
	}

}
