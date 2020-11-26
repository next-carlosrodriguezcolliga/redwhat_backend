package com.hackaton.redwhat.services.contents.model;

import java.util.List;

import org.bson.codecs.pojo.annotations.BsonId;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.quarkus.mongodb.panache.MongoEntity;
import io.quarkus.mongodb.panache.PanacheMongoEntityBase;

@MongoEntity(collection = "contents")
@JsonIgnoreProperties
public class Content extends PanacheMongoEntityBase {

	private Integer sectionId;
	
	@BsonId
	private Integer contentId;
	
	private String description;
	
	private int pointsReward;
	
	private int level;
	
	private String url;
	
	private double latitude;
	
	private double longitude;
	
	private int size;
	
	private String tooltip;
	
	private String fill;

	// entity methods
	public static Content findByContentId(int contentId) {
		return find("contentId", contentId).firstResult();
	}
	
	public static List<Content> findBySectionId(int sectionId) {
		return find("sectionId", sectionId).list();
	}
	
	public static void deleteByContentId(int userId) {
		delete("contentId", userId);
	}
		
	public int getSectionId() {
		return sectionId;
	}

	public void setSectionId(int sectionId) {
		this.sectionId = sectionId;
	}

	public int getContentId() {
		return contentId;
	}

	public void setContentId(int contentId) {
		this.contentId = contentId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPointsReward() {
		return pointsReward;
	}

	public void setPointsReward(int pointsReward) {
		this.pointsReward = pointsReward;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getTooltip() {
		return tooltip;
	}

	public void setTooltip(String tooltip) {
		this.tooltip = tooltip;
	}

	public String getFill() {
		return fill;
	}

	public void setFill(String fill) {
		this.fill = fill;
	}

	@Override
	public String toString() {
		return "Content [sectionId=" + sectionId + ", contentId=" + contentId + ", description=" + description
				+ ", pointsReward=" + pointsReward + ", level=" + level + ", url=" + url + ", latitude=" + latitude
				+ ", longitude=" + longitude + ", size=" + size + ", tooltip=" + tooltip + ", fill=" + fill + "]";
	}

}
