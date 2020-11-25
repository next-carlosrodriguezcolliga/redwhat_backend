package com.hackaton.redwhat.services.users.controller;

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

import com.hackaton.redwhat.model.User;


@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    
    @Inject
    UsersService usersService;

//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response addUser(@Valid ToDo user) {
//        LOGGER.info("User add: {}", user);
//        usersService.addUser(user);
//        try {
//            if (user == null) {
//                return Response.status(400).entity("User not provided").build();
//            }
//            return Response.ok(usersService.addUser(user)).build();
//        }
//        catch (Exception e){
//            return Response.serverError().build();
//        }
//    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addUser(@Valid User user) {
        LOGGER.info("User add: {}", user);
        usersService.addUser(user);
        try {
            if (user == null) {
                return Response.status(400).entity("User not provided").build();
            }
            return Response.ok(usersService.addUser(user)).build();
        }
        catch (Exception e){
            return Response.serverError().build();
        }
    }

    @Path("/{id}")
    @GET
    public Response getUserById(@PathParam("id") String id) {
        LOGGER.info("User get: id={}", id);
        return Response.ok(usersService.getUser(id)).build();
    }
    
//    @Path("/{id}")
//    @PATCH
//    public Response updateUserById(@PathParam("id") String id, @Valid ToDo user) {
//        LOGGER.info("User update: id={}", user);
//        return Response.ok(usersService.updateUser(user)).build();
//    }
    
    @Path("/{id}")
    @PATCH
    public Response updateUserById(@PathParam("id") String id, @Valid User user) {
        LOGGER.info("User update: id={}", user);
        return Response.ok(usersService.updateUser(user)).build();
    }
    
    @Path("/{id}")
    @DELETE
    public Response deleteUserById(@PathParam("id") String user_id) {
    	LOGGER.info("Delete add: {}", user_id);
    	return Response.ok(usersService.delete(user_id)).build();
    }
    
//    @Path("/points/{id}")
//    @PATCH
//    @Consumes(MediaType.TEXT_PLAIN)
//    public Response updateUserPointsById(@PathParam("id") String user_id, @Valid String points) {
//        LOGGER.info("User points update: {}", user_id);
//        return Response.ok(usersService.updatePoints(user_id, points)).build();
//    }
//    
//    @Path("/profile/{id}")
//    @PATCH
//    public Response updateUserProfileById(@PathParam("id") String user_id, @Valid String profile) {
//        LOGGER.info("User profile update: {}", user_id);
//        return Response.ok(usersService.updateProfile(user_id, profile)).build();
//    }
//    
//    @Path("/level/{id}")
//    @PATCH
//    public Response updateUserLevelById(@PathParam("id") String user_id, @Valid String level) {
//        LOGGER.info("User level update: {}", user_id);
//        return Response.ok(usersService.updateLevel(user_id, level)).build();
//    }
//    
//    @Path("/content/{id}")
//    @PATCH
//    public Response updateUserContentById(@PathParam("id") String user_id, @Valid String contentId) {
//        LOGGER.info("User content update: {}", user_id);
//        return Response.ok(usersService.updateContent(user_id, contentId)).build();
//    }
}
