package com.cognizant.cmobile.impl.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.cmobile.impl.model.Billing;

@Repository
public interface BillingRepository extends CrudRepository<Billing, ObjectId> {

	List<Billing> findByMobile(final long mobile);
}
