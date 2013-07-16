package com.cognizant.cmobile.impl.repository;

import org.bson.types.ObjectId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.cmobile.impl.model.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, ObjectId> {

	Customer findByUsernameAndPassword(final String userName, final String password);
	
	Customer findByUsername(final String userName);
}
