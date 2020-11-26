package com.hackaton.redwhat.services.contents.model;

import org.bson.codecs.pojo.annotations.BsonId;

import io.quarkus.mongodb.panache.MongoEntity;
import io.quarkus.mongodb.panache.PanacheMongoEntityBase;

@MongoEntity(collection = "sections")
public class Section extends PanacheMongoEntityBase {
	
	@BsonId
	private Integer sectionId;
	
	private String description;
	
	public static Section findBySectionId(int sectionId) {
		return find("sectionId", sectionId).firstResult();
	}
	
	public static void deleteBySectionId(int sectionId) {
		delete("sectionId", sectionId);
	}
		
	public int getSectionId() {
		return sectionId;
	}

	public void setSectionId(int sectionId) {
		this.sectionId = sectionId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Content [sectionId=" + sectionId +  ", description=" + description
				 + "]";
	}

}
