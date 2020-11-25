package com.hackaton.redwhat.services.users.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import com.hackaton.redwhat.model.User;
import com.hackaton.redwhat.services.users.client.ContentsClient;

@ApplicationScoped
public class UsersService {
    
    @Inject
    @RestClient
    private ContentsClient contentsClient;

    public UsersService(){

    }

//    public ToDo addUser(ToDo user){
//        list.add(user);
//        return user;
//    }
    
    public User addUser(User user) {
    	user.setUserId(UUID.randomUUID().toString());
    	user.persist();
    	return getUser(user.getUserId());
    }

//    public ToDo getUser(String id){
//        Optional<ToDo> item = list.stream().filter(toDo -> toDo.getId().equals(id)).findFirst();
//        return item.orElse(null);
//    }
    
    public User getUser(String userId){    	
    	return User.findByUserId(userId);
    }
    
  public User updateUser(String userId, User userToUpdate){
	  User user = getUser(userId);
	  user.setPoints(userToUpdate.getPoints());
	  user.setLevel(userToUpdate.getLevel());
	  user.setAge(userToUpdate.getAge());
	  user.persistOrUpdate();
    return user;
}
    
//    public ToDo updateUser(ToDo userToUpdate){
//    	ToDo user = getUser(userToUpdate.getId());
//    	user.setPoints(userToUpdate.getPoints());
//        user.setProfile(userToUpdate.getProfile());
//        return user;
//    }
//
//    public ToDo updatePoints(String user_id, String points){
//    	ToDo user = getUser(user_id);
//    	user.setPoints(points);
//        return user;
//    }
//    
//    public ToDo updateProfile(String user_id, String profile){
//    	ToDo user = getUser(user_id);
//    	user.setProfile(profile);
//        return user;
//    }
//    
//    public ToDo updateLevel(String user_id, String level){
//    	ToDo user = getUser(user_id);
//    	user.setLevel(level);
//        return user;
//    }
//    
//    public ToDo updateContent(String user_id, String contentId){
//    	ToDo user = getUser(user_id);
//    	ToDoContent content = contentsClient.getContentById(contentId);
//    	user.addContent(content);
//        return user;
//    }

    public boolean delete(String userId){
    	//User user = getUser(id);
        User.deleteByUserId(userId);
        return true;
    }
}

