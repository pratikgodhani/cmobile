package org.cmobile.service;

import org.cmobile.model.SessionCredential;

public interface SessionCredentialService {

	SessionCredential getSessionCredentialByObjectId (final String ObjectId);
	
	SessionCredential saveSessionCredential (final String userName);
}
