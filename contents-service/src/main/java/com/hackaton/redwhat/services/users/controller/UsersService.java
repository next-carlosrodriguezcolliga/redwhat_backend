package com.hackaton.redwhat.services.users.controller;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class UsersService {
    ArrayList<ToDo> list = new ArrayList<>();

    public UsersService(){

    }

    public ToDo addUser(ToDo user){
        list.add(user);
        return user;
    }

    public List<ToDo> allUsers(){
        return list;
    }

    public ToDo getUser(String id){
        Optional<ToDo> item = list.stream().filter(toDo -> toDo.getId().equals(id)).findFirst();
        return item.orElse(null);
    }
    
    public ToDo updateUser(ToDo userToUpdate){
    	ToDo user = getUser(userToUpdate.getId());
    	user.setPoints(userToUpdate.getPoints());
        user.setProfile(userToUpdate.getProfile());
        return user;
    }

    public ToDo updatePoints(String user_id, String points){
    	ToDo user = getUser(user_id);
    	user.setPoints(points);
        return user;
    }
    
    public ToDo updateProfile(String user_id, String profile){
    	ToDo user = getUser(user_id);
    	user.setProfile(profile);
        return user;
    }
    
    public ToDo updateLevel(String user_id, String level){
    	ToDo user = getUser(user_id);
    	user.setLevel(level);
        return user;
    }
    
    public ToDo updateContent(String user_id, ToDoContent content){
    	ToDo user = getUser(user_id);
    	user.addContent(content);
        return user;
    }

    public boolean delete(String id){
        return list.remove(getUser(id));
    }
}

