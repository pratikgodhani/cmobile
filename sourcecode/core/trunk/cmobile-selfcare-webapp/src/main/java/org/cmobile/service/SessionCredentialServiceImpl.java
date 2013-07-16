package org.cmobile.service;

import org.bson.types.ObjectId;
import org.cmobile.model.SessionCredential;
import org.cmobile.repository.SessionCredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessionCredentialServiceImpl implements SessionCredentialService {

	@Autowired
	SessionCredentialRepository sessionCredentialRepository;
	
	@Override
	public SessionCredential getSessionCredentialByObjectId(String objectId) {
		return sessionCredentialRepository.findOne(new ObjectId(objectId));
	}

	@Override
	public SessionCredential saveSessionCredential(String userName) {
		
		return sessionCredentialRepository.save(new SessionCredential(userName));
	}

}
