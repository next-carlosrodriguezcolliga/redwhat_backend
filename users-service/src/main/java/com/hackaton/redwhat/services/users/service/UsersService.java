package com.hackaton.redwhat.services.users.service;

import java.util.ArrayList;
import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import com.hackaton.redwhat.services.users.client.ContentsClient;
import com.hackaton.redwhat.services.users.model.Content;
import com.hackaton.redwhat.services.users.model.User;

@ApplicationScoped
public class UsersService {
    
    @Inject
    @RestClient
    private ContentsClient contentsClient;

    public UsersService(){

    }
    
    public User addUser(User user) {
    	user.setUserId(UUID.randomUUID().toString());
    	user.persist();
    	return getUser(user.getUserId());
    }
    
    public User getUser(String userId){    	
    	return User.findByUserId(userId);
    }
    
  public User updateUser(String userId, User userToUpdate){
	  User user = getUser(userId);
	  user.setPoints(userToUpdate.getPoints());
	  user.setLevel(userToUpdate.getLevel());
	  user.setAge(userToUpdate.getAge());
	  user.setName(userToUpdate.getName());
	  user.persistOrUpdate();
    return user;
}
  
  public User addViewedContentUser(String userId, Integer contentId){
	  User user = getUser(userId);
	  if (user.getViewedContents() == null) {
		  user.setViewedContents(new ArrayList<Integer>());
	  }
	  Content content = contentsClient.getContentById(contentId);
	  user.getViewedContents().add(content.getContentId());
	  user.setPoints(user.getPoints() + content.getPointsReward());
	  user.persistOrUpdate();
    return user;
}

    public boolean delete(String userId){
        User.deleteByUserId(userId);
        return true;
    }
}

