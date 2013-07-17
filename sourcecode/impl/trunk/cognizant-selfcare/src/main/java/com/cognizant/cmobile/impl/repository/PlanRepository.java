package com.cognizant.cmobile.impl.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.cmobile.impl.model.Plan;

@Repository
public interface PlanRepository extends CrudRepository<Plan, ObjectId> {
	List<Plan> findByMobile(final long mobile);
}
