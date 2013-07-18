package com.cognizant.cmobile.impl.model;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="otherNetworkConsumer")
public class OtherNetworkConsumer {
	
	@Id
	private ObjectId id;

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

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

}
