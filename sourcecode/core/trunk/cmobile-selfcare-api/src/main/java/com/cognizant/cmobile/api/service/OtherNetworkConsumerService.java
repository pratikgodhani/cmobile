package com.cognizant.cmobile.api.service;

import java.util.List;

import com.cognizant.cmobile.api.model.OtherNetworkConsumerVO;

public interface OtherNetworkConsumerService {

	OtherNetworkConsumerVO getOtherNetworkConsumers ();
	
	List<String> getOffersForInvitor();
	
	List<String> getOffersForInvitee();
}
