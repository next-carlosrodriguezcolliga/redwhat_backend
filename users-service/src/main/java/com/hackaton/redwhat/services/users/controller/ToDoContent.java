package com.hackaton.redwhat.services.users.controller;

import java.util.UUID;

import javax.validation.constraints.NotNull;

public class ToDoContent {

	@NotNull
    private String id_video;
	
	@NotNull
    private String id_seccion;
	
	@NotNull
    private String description;
	
	@NotNull
    private String points;

    @NotNull
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

	public ToDoContent(String id_video, String id_seccion, String points, String level, String description) {
        this.id_video = UUID.randomUUID().toString();
        this.id_seccion = UUID.randomUUID().toString();
        this.points = points;
        this.description = description;
        this.level = level;
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

