package com.hackaton.redwhat.services.users.service;

import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import com.hackaton.redwhat.services.users.client.ContentsClient;
import com.hackaton.redwhat.services.users.model.AllStatistics;
import com.hackaton.redwhat.services.users.model.Content;
import com.hackaton.redwhat.services.users.model.GeneralStatistics;
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
  
  public boolean updateUserCompletedStatus(int adrenalin, int familiy, int cartoon){    	
	  User user = User.findAnyUser();
	  user.setAdrenalin_completed(user.getAdrenalin_completed() + adrenalin);
	  user.setCartoon_completed(user.getCartoon_completed() + cartoon);
	  user.setFamily_completed(user.getFamily_completed() + familiy);
	  user.persistOrUpdate();
	  return true;
  }
  
  public User getFirstUser() {
	  return User.findAnyUser();
  }
  
  public void addstatics(GeneralStatistics statics) {
	  statics.persist();
  }
  
  public AllStatistics getAllStatics() {
	  AllStatistics allStatics = new AllStatistics();
	  GeneralStatistics generalStatics = getStatics();
	  User user = getFirstUser();
	  
	  Random random = new Random();
	  allStatics.setUsers_online(generalStatics.getUsers_online() + random.nextInt(10 - 1) + 1);
	  allStatics.setUsers_registered(generalStatics.getUsers_registered() + random.nextInt(5 - 1) + 1);
	  allStatics.setAdrenalin_completed(user.getAdrenalin_completed());
	  allStatics.setCartoon_completed(user.getCartoon_completed());
	  allStatics.setFamily_completed(user.getFamily_completed());
	  return allStatics;
  }
  
  public GeneralStatistics getStatics() {
	  return GeneralStatistics.getStatics();
  }
  
  public boolean deleteAllStatics(){
	  GeneralStatistics.deleteAll();
      return true;
  }

    public boolean delete(String userId){
        User.deleteByUserId(userId);
        return true;
    }
    
    public boolean deleteAll(){
        User.deleteAll();
        return true;
    }
}

