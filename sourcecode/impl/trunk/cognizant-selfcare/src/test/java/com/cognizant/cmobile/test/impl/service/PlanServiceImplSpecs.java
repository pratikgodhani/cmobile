package com.cognizant.cmobile.test.impl.service;

import static org.mockito.BDDMockito.given;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import com.cognizant.cmobile.api.model.CustomerVO;
import com.cognizant.cmobile.api.model.PlanFeatureVO;
import com.cognizant.cmobile.api.model.PlanVO;
import com.cognizant.cmobile.api.service.PlanService;
import com.cognizant.cmobile.impl.model.PlanFeature;
import com.cognizant.cmobile.impl.model.Plan;
import com.cognizant.cmobile.impl.repository.PlanRepository;
import com.cognizant.cmobile.impl.service.PlanServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class PlanServiceImplSpecs {

	@Mock
	private PlanRepository planRepository;

	@Mock
	CustomerVO customerVO;

	@InjectMocks
	private PlanService planService = new PlanServiceImpl();

	@Test
	public void getPlansTest() {

		List<Plan> plans = new ArrayList<Plan>();
		List<PlanFeature> features = new ArrayList<PlanFeature>();
		List<PlanVO> expectedOutput = new ArrayList<PlanVO>();
		List<PlanFeatureVO> planFeatureList = new ArrayList<PlanFeatureVO>();

		Plan plan = new Plan();
		plan.setName("CR199");
		plan.setDescription("Rental plan 199/month");
		plan.setMobile(8087015567l);

		PlanFeature f1 = new PlanFeature();
		f1.setName("Onnet call rate");
		f1.setRate(10);
		f1.setUnit("paise/minute");
		f1.setVisible(true);
		PlanFeature f2 = new PlanFeature();
		f2.setName("Offnet call rate");
		f2.setRate(30);
		f2.setUnit("paise/minute");
		f2.setVisible(true);

		features.add(f1);
		features.add(f2);

		plan.setFeatures(features);
		plans.add(plan);

		PlanFeatureVO pf1 = new PlanFeatureVO();
		pf1.setName("Onnet call rate");
		pf1.setVisible(true);
		pf1.setDescription("10.00 paise/minute");
		planFeatureList.add(pf1);

		PlanFeatureVO pf2 = new PlanFeatureVO();
		pf2.setName("Offnet call rate");
		pf2.setVisible(true);
		pf2.setDescription("30.00 paise/minute");
		planFeatureList.add(pf2);

		PlanVO planVO = new PlanVO();
		planVO.setName("CR199");
		planVO.setFeatures(planFeatureList);
		planVO.setDescription("Rental plan 199/month");

		expectedOutput.add(planVO);

		given(customerVO.getMobile()).willReturn(8087015567l);
		given(planRepository.findByMobile(8087015567l)).willReturn(plans);

		List<PlanVO> actualOutput = planService.getPlans();

		Assert.assertNotNull(actualOutput);
		Assert.assertEquals(actualOutput.size(), expectedOutput.size());
		for(int i=0; i<actualOutput.size();i++){
			Assert.assertEquals(expectedOutput.get(i), actualOutput.get(i));
		}
	}

}
