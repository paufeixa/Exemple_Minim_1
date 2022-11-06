package edu.upc.dsa.services;

import edu.upc.dsa.data.MyObjectManager;
import edu.upc.dsa.data.MyObjectManagerImpl;
import edu.upc.dsa.models.MyObject;
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
public class MyObjectService {
    private MyObjectManager om;

    public MyObjectService() {
        this.om = MyObjectManagerImpl.getInstance();
    }

    @POST
    @ApiOperation(value = "create a new Object", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful", response= MyObject.class),
            @ApiResponse(code = 500, message = "Error")
    })
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newObject(MyObject myObject) {
        if (myObject.getObjectId()==null || myObject.getName()==null || myObject.getDescription()==null || myObject.getCoins()==0) {
            return Response.status(500).entity(myObject).build();
        }
        this.om.addObject(myObject.getObjectId(), myObject.getName(), myObject.getDescription(), myObject.getCoins());
        return Response.status(200).entity(myObject).build();
    }

    @GET
    @ApiOperation(value = "get all Objects", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful", response = MyObject.class, responseContainer="List"),
    })
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getObject() {

        List<MyObject> myObjects = this.om.objectsByPrice();

        GenericEntity<List<MyObject>> entity = new GenericEntity<List<MyObject>>(myObjects) {};
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
