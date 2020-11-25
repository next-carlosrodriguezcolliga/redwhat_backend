package com.hackaton.redwhat.services.users.controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ToDoContent {

    private String id_video;
	
    private String id_seccion;
	
    private String description;
	
    private String points;

    private String level;

  

    public String getId_video() {
		return id_video;
	}

	public void setId_video(String id_video) {
		this.id_video = id_video;
	}

	public String getId_seccion() {
		return id_seccion;
	}

	public void setId_seccion(String id_seccion) {
		this.id_seccion = id_seccion;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPoints() {
		return points;
	}

	public void setPoints(String points) {
		this.points = points;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}
	
	public ToDoContent() {
		
	}

    @Override
    public String toString() {
        return "ToDo{" +
                "id_video='" + id_video + '\'' +
                ", id_seccion='" + id_seccion + '\'' +
                 ", level='" + level + '\'' +
                 ", description='" + description + '\'' +
                ", points=" + points +
                '}';
    }
}

