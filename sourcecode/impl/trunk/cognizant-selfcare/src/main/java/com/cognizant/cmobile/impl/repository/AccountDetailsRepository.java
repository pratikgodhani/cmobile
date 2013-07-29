package com.cognizant.cmobile.impl.repository;

import org.bson.types.ObjectId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.cmobile.impl.model.AccountDetails;

@Repository
public interface AccountDetailsRepository extends
		CrudRepository<AccountDetails, ObjectId> {

	AccountDetails findByMobile(final long mobile);
}
