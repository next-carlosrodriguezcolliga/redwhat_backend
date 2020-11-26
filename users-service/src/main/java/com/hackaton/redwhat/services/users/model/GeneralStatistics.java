package com.hackaton.redwhat.services.users.model;

import io.quarkus.mongodb.panache.MongoEntity;
import io.quarkus.mongodb.panache.PanacheMongoEntity;

@MongoEntity(collection = "statistics")
public class GeneralStatistics extends PanacheMongoEntity {

	private int users_online;
	
	private int users_registered;

	public int getUsers_online() {
		return users_online;
	}

	public void setUsers_online(int users_online) {
		this.users_online = users_online;
	}

	public int getUsers_registered() {
		return users_registered;
	}

	public void setUsers_registered(int users_registered) {
		this.users_registered = users_registered;
	}
	
	public static GeneralStatistics getStatics() {
		return findAll().firstResult();
	}

	
	
	
}
