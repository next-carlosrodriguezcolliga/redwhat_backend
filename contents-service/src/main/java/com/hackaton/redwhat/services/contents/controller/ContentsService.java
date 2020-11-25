package com.hackaton.redwhat.services.contents.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ContentsService {
    ArrayList<ToDoContent> list = new ArrayList<>();

    public ContentsService(){

    }

    public ToDoContent addContent(ToDoContent content){
        list.add(content);
        return content;
    }

    public List<ToDoContent> allContent(){
        return list;
    }

    public ToDoContent getContent(String id){
        Optional<ToDoContent> item = list.stream().filter(toDo -> toDo.getId_video().equals(id)).findFirst();
        return item.orElse(null);
    }
    
    public ToDoContent updateContent(ToDoContent contentToUpdate){
    	ToDoContent content = getContent(contentToUpdate.getId_video());
    	content.setPoints(contentToUpdate.getPoints());
    	content.setDescription(contentToUpdate.getDescription());
    	content.setId_seccion(contentToUpdate.getId_seccion());
    	content.setLevel(contentToUpdate.getLevel());
        return content;
    }
   
    public boolean deleteContent(String id){
        return list.remove(getContent(id));
    }
}

