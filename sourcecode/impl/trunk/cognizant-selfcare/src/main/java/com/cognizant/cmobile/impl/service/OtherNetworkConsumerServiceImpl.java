package com.cognizant.cmobile.impl.service;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.cmobile.api.model.CustomerVO;
import com.cognizant.cmobile.api.model.OtherNetworkConsumerVO;
import com.cognizant.cmobile.api.service.OtherNetworkConsumerService;
import com.cognizant.cmobile.impl.model.OtherNetworkConsumer;
import com.cognizant.cmobile.impl.repository.OtherNetworkConsumerRepository;

@Service("otherNetworkCustomerService")
public class OtherNetworkConsumerServiceImpl implements OtherNetworkConsumerService {

	@Autowired
	OtherNetworkConsumerRepository otherNetworkConsumerRepository;
	
	@Autowired
	CustomerVO customerVO;
	
	public OtherNetworkConsumerVO getOtherNetworkConsumers() {
		return convertPojoToVO(otherNetworkConsumerRepository.findByMobile(customerVO.getMobile()));
	}

	public List<String> getOffersForInvitor() {
		List<String> offersForInvitor = new ArrayList<String>();
		offersForInvitor.add("Offer For Invitor 1");
		offersForInvitor.add("Offer For Invitor 2");
		offersForInvitor.add("Offer For Invitor 3");
		return offersForInvitor;
	}

	public List<String> getOffersForInvitee() {
		List<String> offersForInvitee = new ArrayList<String>();
		offersForInvitee.add("Offer For Invitee 1");
		offersForInvitee.add("Offer For Invitee 2");
		offersForInvitee.add("Offer For Invitee 3");
		return offersForInvitee;
	}

	private OtherNetworkConsumerVO convertPojoToVO(final OtherNetworkConsumer otherNetworkCustomer) {
		Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
		return mapper.map(otherNetworkCustomer, OtherNetworkConsumerVO.class);
	}
}
