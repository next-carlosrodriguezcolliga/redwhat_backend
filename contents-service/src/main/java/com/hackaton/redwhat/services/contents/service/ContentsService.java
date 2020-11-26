package com.hackaton.redwhat.services.contents.service;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import com.hackaton.redwhat.services.contents.model.AllData;
import com.hackaton.redwhat.services.contents.model.Content;
import com.hackaton.redwhat.services.contents.model.Section;


@ApplicationScoped
public class ContentsService {

    public ContentsService(){

    }

    public Content addContent(Content content){
    	content.persist();
    	return Content.findByContentId(content.getContentId());
    }
    
    public Section addSection(Section section){
    	section.persist();
    	return Section.findBySectionId(section.getSectionId());
    }
    
    public List<Section> getAllSections(){
    	return Section.findAll().list();
    }
    
    public List<Content> getContentBySectionId(Integer sectionId){
    	return Content.findBySectionId(sectionId);
    }
    
    public List<Section> getAllContents(){
    	return Content.findAll().list();
    }
    
    public List<AllData> getAllSectionsAndContents(){
    	List<Section> sections = Section.findAll().list();
    	
    	List<AllData> allDataList = new ArrayList<AllData>();
    	for (Section section: sections) {
    		AllData allData = new AllData();
    		allData.setSectionId(section.getSectionId());
    		allData.setDescription(section.getDescription());
    		allData.setContentIdList(Content.findBySectionId(section.getSectionId()));
    		allDataList.add(allData);
    	}
    	return allDataList;
    }

    public Content getContent(Integer contentId){
    	return Content.findById(contentId);
    }
    
    public Content updateContent(Content contentToUpdate){
    	Content content = getContent(contentToUpdate.getContentId());
    	content.setDescription(contentToUpdate.getDescription());
    	content.setFill(contentToUpdate.getFill());
    	content.setLatitude(contentToUpdate.getLatitude());
    	content.setLongitude(contentToUpdate.getLongitude());
    	content.setPointsReward(contentToUpdate.getPointsReward());
    	content.setSize(contentToUpdate.getSize());
    	content.setTooltip(contentToUpdate.getTooltip());
    	content.setUrl(contentToUpdate.getUrl());
    	content.setLevel(contentToUpdate.getLevel());
    	content.persistOrUpdate();
        return content;
    }
   
    public boolean delete(int contentId){
        Content.deleteByContentId(contentId);
        return true;
    }
    
    public boolean deleteAllSections(){
        Section.deleteAll();
        return true;
    }
    
    public boolean deleteAllContents(){
        Content.deleteAll();
        return true;
    }
}

