package com.hackaton.redwhat.services.contents.model;

import java.util.ArrayList;
import java.util.List;

public class AllData {

	private int sectionId;
	private String description;
	private List<Content> contentIdList = new ArrayList<Content>();
		
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



	public List<Content> getContentIdList() {
		return contentIdList;
	}

	public void setContentIdList(List<Content> contentIdList) {
		this.contentIdList = contentIdList;
	}

	@Override
	public String toString() {
		return "Content [sectionId=" + sectionId +  ", description=" + description
				 + "]";
	}

}
