package com.cognizant.cmobile.impl.repository;

import org.bson.types.ObjectId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.cmobile.impl.model.OtherNetworkConsumer;

@Repository
public interface OtherNetworkConsumerRepository extends CrudRepository<OtherNetworkConsumer, ObjectId> {

	OtherNetworkConsumer findByMobile(final long mobile);
	
}
