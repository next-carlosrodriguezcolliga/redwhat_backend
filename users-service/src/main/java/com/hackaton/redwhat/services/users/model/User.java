package com.hackaton.redwhat.services.users.model;

import java.util.List;

import io.quarkus.mongodb.panache.MongoEntity;
import io.quarkus.mongodb.panache.PanacheMongoEntity;

@MongoEntity(collection = "users")
public class User extends PanacheMongoEntity {

	private String userId;

	private int points;

	private int level;
	
	private String name;

	private List<Integer> viewedContents;

	private int age;

	public String getUserId() {
		return userId;
	}

	// entity methods
	public static User findByUserId(String userId) {
		return find("userId", userId).firstResult();
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

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
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

	@Override
	public String toString() {
		return "User [userId=" + userId + ", points=" + points + ", level=" + level + ", viewedContents="
				+ viewedContents + ", age=" + age + "]";
	}

}
