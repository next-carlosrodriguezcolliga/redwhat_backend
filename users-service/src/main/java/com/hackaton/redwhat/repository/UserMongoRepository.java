package com.hackaton.redwhat.repository;

import javax.enterprise.context.ApplicationScoped;

import org.bson.types.ObjectId;

import com.hackaton.redwhat.model.User;

import io.quarkus.mongodb.panache.PanacheMongoRepository;


@ApplicationScoped
public class UserMongoRepository implements PanacheMongoRepository<User>{
	
	
	public User insert(User user) {
		persistOrUpdate(user);
		return findUser(user.getUserId());
	}
	
	public User findUser(String userId) {
		return findById(new ObjectId(userId));
	}

}
