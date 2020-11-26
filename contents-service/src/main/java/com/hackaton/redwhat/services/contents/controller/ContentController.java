package com.hackaton.redwhat.services.contents.controller;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hackaton.redwhat.services.contents.model.Content;
import com.hackaton.redwhat.services.contents.model.Section;
import com.hackaton.redwhat.services.contents.service.ContentsService;



@Path("/contents")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ContentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ContentController.class);
    
    @Inject
    ContentsService contentService;

    @POST
    @Path("/addContent")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addContent(@Valid Content content) {
        LOGGER.info("Content add: {}", content);
       
        try {
            if (content == null) {
                return Response.status(400).entity("Content not provided").build();
            }
            Content contentCreated = contentService.addContent(content);
            return Response.ok(contentCreated).build();
        }
        catch (Exception e){
            return Response.serverError().build();
        }
    }
    
    @POST
    @Path("/addSection")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addSection(@Valid Section section) {
        LOGGER.info("Section add: {}", section);
       
        try {
            if (section == null) {
                return Response.status(400).entity("Content not provided").build();
            }
            Section contentCreated = contentService.addSection(section);
            return Response.ok(contentCreated).build();
        }
        catch (Exception e){
            return Response.serverError().build();
        }
    }
    
    @Path("/sections")
    @GET
    public Response getAllSections() {
        LOGGER.info("Sections get");
        return Response.ok(contentService.getAllSections()).build();
    }
    
    @Path("/contentsFilteredBySection/{sectionId}")
    @GET
    public Response getAllContents(@PathParam("sectionId")  Integer sectionId) {
        LOGGER.info("Contents get");
        if (sectionId == null) {
        	return Response.ok(contentService.getAllContents()).build();
        }
        else {
        	return Response.ok(contentService.getContentBySectionId(sectionId)).build();
        }
    }
    
//    @Path("/dataMap")
//    @GET
//    public Response getDataMap() {
//        LOGGER.info("Get all data");
//        return Response.ok(contentService.getAllSectionsAndContents()).build();
//    }
    
    @GET
    public Response getAllData() {
        LOGGER.info("Get all contents");
        return Response.ok(contentService.getAllSectionsAndContents()).build();
    }

    @Path("/{contentId}")
    @GET
    public Response getContentById(@PathParam("contentId") Integer contentId) {
        LOGGER.info("Content get: contentId={}", contentId);
        return Response.ok(contentService.getContent(contentId)).build();
    }
    
    
    @Path("/{contentId}")
    @PATCH
    public Response updateContentById(@PathParam("contentId") String contentId, @Valid Content content) {
        LOGGER.info("Content update: id={}", content);
        return Response.ok(contentService.updateContent(content)).build();
    }
    
    @Path("/{contentId}")
    @DELETE
    public Response deleteContentById(@PathParam("contentId") String contentId) {
    	LOGGER.info("Delete add: {}", contentId);
    	return Response.ok(contentService.delete(Integer.valueOf(contentId))).build();
    }
    
}
