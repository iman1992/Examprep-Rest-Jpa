/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import facade.Facade;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Iman H
 */
@Path("api")
public class Countryresouce {
  Gson gson;
    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of Countryresouce
     */
    public Countryresouce() {
                gson = gson = new GsonBuilder().setPrettyPrinting().setFieldNamingPolicy(FieldNamingPolicy.IDENTITY).create();

    }

    /**
     * Retrieves representation of an instance of api.Countryresouce
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public Response getCountries(){
      return Response.status(Response.Status.OK).entity(gson.toJson(Facade.getCountries())).build();
    
    }

    /**
     * PUT method for updating or creating an instance of Countryresouce
     * @param content representation for the resource
     */
    @GET
    @Path("{p}")
    @Produces("application/json")
    public Response getCountriesByPopulation(@PathParam("p")int n){
        return Response.status(Response.Status.OK).entity(gson.toJson(Facade.getCountriesByPopulation(n))).build();
    
    }
}
