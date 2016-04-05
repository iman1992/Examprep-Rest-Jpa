/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Iman H
 */
@Path("api")
public class Cityresouce {
    
    Gson gson;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of Cityresouce
     */
    public Cityresouce() {
        gson = gson = new GsonBuilder().setPrettyPrinting().setFieldNamingPolicy(FieldNamingPolicy.IDENTITY).create();
    }

    /**
     * Retrieves representation of an instance of api.Cityresouce
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{c}")
    @Produces("application/json")
    public Response getCities(@PathParam("c") String code){
        return Response.status(Response.Status.OK).entity(gson.toJson(facade.Facade.getCities(code))).build();
    }

    /**
     * PUT method for updating or creating an instance of Cityresouce
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
