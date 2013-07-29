package com.cognizant.cmobile.impl.repository;

import org.bson.types.ObjectId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.cmobile.impl.model.MyBill;

@Repository
public interface MyBillRepository extends CrudRepository<MyBill, ObjectId> {

	MyBill findByMobile(final long mobile);
}
