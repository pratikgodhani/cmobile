package org.cmobile.model;

import java.io.Serializable;

import org.bson.types.ObjectId;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "SessionCredential")
@Scope(value="session",proxyMode= ScopedProxyMode.TARGET_CLASS)
public class SessionCredential implements Serializable {

	/**
	 * Auto generated serial version id.
	 */
	private static final long serialVersionUID = 1955779041808994956L;
	private ObjectId id;
	private String username;

	public SessionCredential(final String username) {
		super();
		this.username = username;
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
