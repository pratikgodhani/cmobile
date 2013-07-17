package com.cognizant.cmobile.impl.model;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Represents a post-paid plan
 * 
 * @author cts1
 * 
 */
@Document(collection = "plan")
public class Plan {

	@Id
	private ObjectId id;
	private String name;
	private String description;
	private Long mobile;
	private List<PlanFeature> features;

	public void setId(ObjectId id) {
		this.id = id;
	}

	public ObjectId getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}

	public Long getMobile() {
		return mobile;
	}
	
	public void setFeatures(List<PlanFeature> features) {
		this.features = features;
	}
	
	public List<PlanFeature> getFeatures() {
		return features;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (mobile ^ (mobile >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Plan other = (Plan) obj;
		if (mobile != other.mobile)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
