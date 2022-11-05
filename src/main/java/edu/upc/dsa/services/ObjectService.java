package edu.upc.dsa.services;

import edu.upc.dsa.data.ObjectManager;
import edu.upc.dsa.data.ObjectManagerImpl;
import edu.upc.dsa.models.Object;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Api(value = "/object", description = "Endpoint to Object Service")
@Path("/object")
public class ObjectService {
    private ObjectManager om;

    public ObjectService() {
        this.om = ObjectManagerImpl.getInstance();
    }

    @POST
    @ApiOperation(value = "create a new Object", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful", response=Object.class),
            @ApiResponse(code = 500, message = "Error")
    })
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newObject(Object object) {
        if (object.getObjectId()==null || object.getName()==null || object.getDescription()==null || object.getCoins()==0) {
            return Response.status(500).entity(object).build();
        }
        this.om.addObject(object.getObjectId(), object.getName(), object.getDescription(), object.getCoins());
        return Response.status(200).entity(object).build();
    }

    @GET
    @ApiOperation(value = "get all Objects", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful", response = Object.class, responseContainer="List"),
    })
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getObject() {

        List<Object> objects = this.om.objectsByPrice();

        GenericEntity<List<Object>> entity = new GenericEntity<List<Object>>(objects) {};
        return Response.status(200).entity(entity).build();
    }
/**
    @GET
    @ApiOperation(value = "get a Track", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Track.class),
            @ApiResponse(code = 404, message = "Track not found")
    })
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTrack(@PathParam("id") String id) {
        Track t = this.tm.getTrack(id);
        if (t == null) return Response.status(404).build();
        else  return Response.status(201).entity(t).build();
    }

    @PUT
    @ApiOperation(value = "update a Track", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "Track not found")
    })
    @Path("/")
    public Response updateTrack(Track track) {

        Track t = this.tm.updateTrack(track);

        if (t == null) return Response.status(404).build();

        return Response.status(201).build();
    }
    */
}
