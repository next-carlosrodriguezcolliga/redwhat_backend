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



@Path("/contents")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ContentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ContentController.class);
    
    @Inject
    ContentsService contentService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addContent(@Valid ToDoContent content) {
        LOGGER.info("Content add: {}", content);
        contentService.addContent(content);
        try {
            if (content == null) {
                return Response.status(400).entity("Content not provided").build();
            }
            return Response.ok(contentService.addContent(content)).build();
        }
        catch (Exception e){
            return Response.serverError().build();
        }
    }

    @Path("/{id}")
    @GET
    public ToDoContent getContentById(@PathParam("id") String id) {
        LOGGER.info("Content get: id={}", id);
        return contentService.getContent(id);
    }
    
    
    @Path("/{id}")
    @PATCH
    public Response updateContentById(@PathParam("id") String id, @Valid ToDoContent content) {
        LOGGER.info("Content update: id={}", content);
        return Response.ok(contentService.updateContent(content)).build();
    }
    
    @Path("/{id}")
    @DELETE
    public Response deleteContentById(@PathParam("id") String id) {
    	LOGGER.info("Delete add: {}", id);
    	return Response.ok(contentService.deleteContent(id)).build();
    }
    
}
