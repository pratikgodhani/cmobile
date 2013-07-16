package org.cmobile.repository;

import org.bson.types.ObjectId;
import org.cmobile.model.SessionCredential;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionCredentialRepository extends CrudRepository<SessionCredential, ObjectId> {
	
}
