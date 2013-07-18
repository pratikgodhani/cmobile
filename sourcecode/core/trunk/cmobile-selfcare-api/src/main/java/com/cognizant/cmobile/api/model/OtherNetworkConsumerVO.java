package com.cognizant.cmobile.api.model;

import java.util.List;

public class OtherNetworkConsumerVO {

	private long mobile;
	private List<String> otherNetworkMobile;

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public List<String> getOtherNetworkMobile() {
		return otherNetworkMobile;
	}

	public void setOtherNetworkMobile(List<String> otherNetworkMobile) {
		this.otherNetworkMobile = otherNetworkMobile;
	}

}
