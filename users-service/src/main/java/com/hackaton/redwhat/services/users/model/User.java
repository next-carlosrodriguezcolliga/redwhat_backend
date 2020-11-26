package com.hackaton.redwhat.services.users.model;

import java.util.List;

import io.quarkus.mongodb.panache.MongoEntity;
import io.quarkus.mongodb.panache.PanacheMongoEntity;

@MongoEntity(collection = "users")
public class User extends PanacheMongoEntity {

	private String userId;

	private int points;

	private String user_level;
	
	private String name;
	
	private int cartoon_completed;
	
	private int family_completed;
	
	private int adrenalin_completed;
	

	private List<Integer> viewedContents;

	private int age;

	public String getUserId() {
		return userId;
	}

	// entity methods
	public static User findByUserId(String userId) {
		return find("userId", userId).firstResult();
	}
	
	public static User findAnyUser() {
		return findAll().firstResult();
	}

	public static void deleteByUserId(String userId) {
		delete("userId", userId);
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public String getLevel() {
		return user_level;
	}

	public void setLevel(String user_level) {
		this.user_level = user_level;
	}

	public List<Integer> getViewedContents() {
		return viewedContents;
	}

	public void setViewedContents(List<Integer> viewedContents) {
		this.viewedContents = viewedContents;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUser_level() {
		return user_level;
	}

	public void setUser_level(String user_level) {
		this.user_level = user_level;
	}

	public int getCartoon_completed() {
		return cartoon_completed;
	}

	public void setCartoon_completed(int cartoon_completed) {
		this.cartoon_completed = cartoon_completed;
	}

	public int getFamily_completed() {
		return family_completed;
	}

	public void setFamily_completed(int family_completed) {
		this.family_completed = family_completed;
	}

	public int getAdrenalin_completed() {
		return adrenalin_completed;
	}

	public void setAdrenalin_completed(int adrenalin_completed) {
		this.adrenalin_completed = adrenalin_completed;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", points=" + points + ", level=" + user_level + ", viewedContents="
				+ viewedContents + ", age=" + age + "]";
	}

}
