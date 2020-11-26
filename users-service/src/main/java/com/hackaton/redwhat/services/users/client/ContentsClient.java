package com.hackaton.redwhat.services.users.client;

import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import com.hackaton.redwhat.services.users.model.Content;





@Singleton
@Path("/contents")
@RegisterRestClient
public interface ContentsClient {

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Content getContentById(@PathParam("id") Integer id);

}
