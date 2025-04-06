package com.crm.rest;

import com.crm.dto.AdmiRolDTO;
import com.crm.service.IAdmiRolService;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/rol")
public class RolController {

    @Inject
    IAdmiRolService roleService; 


    @POST
    @Consumes(MediaType.APPLICATION_JSON)  
    @Produces(MediaType.APPLICATION_JSON)  
    public Response createRole(AdmiRolDTO roleDTO) {
        try {
            AdmiRolDTO createdRole = roleService.save(roleDTO); 
            return Response.status(Response.Status.CREATED).entity(createdRole).build();  
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("{\"message\": \"Error  role: " + e.getMessage() + "\"}")
                    .build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateRole(AdmiRolDTO roleDTO) {
        try {
            AdmiRolDTO updatedRole = roleService.update(roleDTO); 
            return Response.ok(updatedRole).build(); 
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("{\"message\": \"Role no encontrado: " + e.getMessage() + "\"}")
                    .build();
        }
    }


    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRoleById(@PathParam("id") Long id) {
        try {
            AdmiRolDTO roleDTO = roleService.findById(id);
            if (roleDTO == null) {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("{\"message\": \"Role no encontrado\"}")
                        .build();
            }
            return Response.ok(roleDTO).build(); 
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("{\"message\": \"Error  role: " + e.getMessage() + "\"}")
                    .build();
        }
    }

 
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllRoles() {
        try {
            return Response.ok(roleService.findAll()).build(); 
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("{\"message\": \"Error  roles: " + e.getMessage() + "\"}")
                    .build();
        }
    }
}
