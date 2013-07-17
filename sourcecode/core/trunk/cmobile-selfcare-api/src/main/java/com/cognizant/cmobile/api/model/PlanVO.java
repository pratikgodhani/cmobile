package com.cognizant.cmobile.api.model;

import java.util.List;

/**
 * Represents a post-paid plan
 * 
 * @author cts1
 * 
 */
public class PlanVO {

	private String name;
	private String description;
	private List<PlanFeatureVO> features;

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
	
	public void setFeatures(List<PlanFeatureVO> features) {
		this.features = features;
	}
	
	public List<PlanFeatureVO> getFeatures() {
		return features;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		PlanVO other = (PlanVO) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
