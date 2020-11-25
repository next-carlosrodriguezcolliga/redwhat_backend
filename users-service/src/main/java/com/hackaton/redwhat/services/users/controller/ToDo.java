package com.hackaton.redwhat.services.users.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.validation.constraints.NotNull;



public class ToDo {

	@NotNull
    private String id;
	
	@NotNull
    private String name;
	
	@NotNull
    private String level;
	
	@NotNull
    private Date age;

    @NotNull
    private String profile;

    @NotNull
    private String points;
    
    private List<ToDoContent> contents;

    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getPoints() {
		return points;
	}

	public void setPoints(String puntos) {
		this.points = puntos;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public Date getAge() {
		return age;
	}

	public void setAge(Date edad) {
		this.age = edad;
	}

	public List<ToDoContent> getContents() {
		return contents;
	}

	public void addContent(ToDoContent content) {
		if (this.contents == null) {
			this.contents = new ArrayList<ToDoContent>();
		}
		this.contents.add(content);
	}

	public ToDo() {

    }

    public ToDo(String id, String profile, String points, String level, Date age) {
        this.id = UUID.randomUUID().toString();
        this.profile = profile;
        this.points = points;
        this.level = level;
        this.age = age;
        this.contents = new ArrayList<ToDoContent>();
    }

    @Override
    public String toString() {
        return "ToDo{" +
                "id='" + id + '\'' +
                ", profile='" + profile + '\'' +
                 ", level='" + level + '\'' +
                 ", age='" + age + '\'' +
                ", points=" + points +
                '}';
    }
}

