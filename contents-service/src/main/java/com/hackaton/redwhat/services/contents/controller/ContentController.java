package com.hackaton.redwhat.services.contents.controller;

import javax.enterprise.event.Observes;
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

import io.quarkus.runtime.StartupEvent;

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
    
    public void onStart(@Observes StartupEvent ev) {               
        LOGGER.info("The application is starting...");
        contentService.deleteAllSections();
        contentService.deleteAllContents();
        
        Section section = new Section();
        section.setSectionId(1);
        section.setDescription("Cartoon World");
        contentService.addSection(section);
        contentService.addContent(getContent(1, 1, "#000", "Aprendiendo a ahorrar", 34.546708, -90.211471, 10, 5, "/app/cartoon"));
        contentService.addContent(getContent(1, 2, "#000", "¿Qué es para ti la banca?", 33.84463, -118.157483, 5, 5, "/app/cartoon/what-is-banking"));
        contentService.addContent(getContent(1, 3, "#000", "¿Qué es ahorrar?", 30.700644, -95.145249, 10, 6, "/app/cartoon"));
        contentService.addContent(getContent(1, 4, "#000", "¿Qué es banca?", 26.93508, -80.851766, 20, 9, "/app/cartoon/banking"));
        
        section = new Section();
        section.setSectionId(2);
        section.setDescription("Adrenalin World");
        contentService.addSection(section);
        contentService.addContent(getContent(2, 5, "#000", "Hablemos de finanzas", 37.792032, -122.394613, 10, 5, "/app/adrenalin"));
        contentService.addContent(getContent(2, 6, "#000", "TikTokers", 	33.145235, -83.811834, 5, 5, "/app/adrenalin/tiktok"));
        contentService.addContent(getContent(2, 7, "#000", "¿Qué es la bolsa?", 40.717079, -74.00116, 10, 6, "/app/adrenalin"));
        
        section = new Section();
        section.setSectionId(3);
        section.setDescription("Family World");
        contentService.addSection(section);
        contentService.addContent(getContent(3, 8, "#000", "Economía familiar", 36.269356, 	-76.587477, 10, 8, "/app/family"));
        contentService.addContent(getContent(3, 9, "#000", "Tu Cuenta", 32.628599, -103.675115, 5, 5, "/app/family"));
        contentService.addContent(getContent(3, 10, "#000", "Tu Gestor", 40.456692, -83.522688, 10, 6, "/app/family"));
        contentService.addContent(getContent(3, 11, "#000", "Tu oficina", 36.331308, -83.33605, 10, 4, "/app/family"));

    }

	private Content getContent(Integer sectionId, Integer contentId, String fill, String desc, 
			double latitude, double longitude, int points, int size, String url) {
		Content content = new Content();
        content.setSectionId(sectionId);
        content.setContentId(contentId);
        content.setFill(fill);
        content.setDescription(desc);
        content.setTooltip(desc);
        content.setLatitude(latitude);
        content.setLongitude(longitude);
        content.setPointsReward(points);
        content.setSize(size);
        content.setUrl(url);
		return content;
	}
    
}
