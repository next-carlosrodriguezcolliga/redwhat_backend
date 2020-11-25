package com.hackaton.redwhat.services.users.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;


import org.eclipse.microprofile.rest.client.inject.RestClient;

import com.hackaton.redwhat.model.User;
import com.hackaton.redwhat.repository.UserMongoRepository;
import com.hackaton.redwhat.services.users.client.ContentsClient;

@ApplicationScoped
public class UsersService {
    ArrayList<ToDo> list = new ArrayList<>();
    
    @Inject
    @RestClient
    private ContentsClient contentsClient;
    
    @Inject
    private UserMongoRepository repository;

    public UsersService(){

    }

//    public ToDo addUser(ToDo user){
//        list.add(user);
//        return user;
//    }
    
    public User addUser(User user) {
    	//return repository.insert(user);
    	user.persist();
    	return User.findByUserId(user.getUserId());
    }

    public List<ToDo> allUsers(){
        return list;
    }

//    public ToDo getUser(String id){
//        Optional<ToDo> item = list.stream().filter(toDo -> toDo.getId().equals(id)).findFirst();
//        return item.orElse(null);
//    }
    
    public User getUser(String id){    	
    	return User.findByUserId(id);
    }
    
  public User updateUser(User userToUpdate){
	  User user = getUser(userToUpdate.getUserId());
	  user.setPoints(userToUpdate.getPoints());
	  user.setLevel(userToUpdate.getLevel());
	  user.setAge(userToUpdate.getAge());
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

    public boolean delete(String id){
        return list.remove(getUser(id));
    }
}

