package com.crm.rest;

import com.crm.dto.InfoPersonaDTO;
import com.crm.dto.ProspectoDTO;
import com.crm.service.IInfoPersonaService;
import com.crm.service.IProspectoService;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/persona")
public class PersonaController {

    @Inject
    IInfoPersonaService personaService;  
    
    @Inject
    IProspectoService prospectoService;
    
    
    
    
    
    @POST
    @Path("/crearProspecto")
    @Consumes(MediaType.APPLICATION_JSON)  
    @Produces(MediaType.APPLICATION_JSON) 
    public Response createProspecto(ProspectoDTO personaDTO) {
        try {
            InfoPersonaDTO createdPersona = prospectoService.crateProspecto(personaDTO); 
            return Response.status(Response.Status.CREATED).entity(createdPersona).build(); 
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("{\"message\": \"Error  persona: " + e.getMessage() + "\"}")
                    .build();
        }
    }
    
    @POST
    @Path("/actualizarProspecto")
    @Consumes(MediaType.APPLICATION_JSON)  
    @Produces(MediaType.APPLICATION_JSON) 
    public Response actualizarProspecto(ProspectoDTO personaDTO) {
        try {
            InfoPersonaDTO createdPersona = prospectoService.actualizarProspecto(personaDTO); 
            return Response.status(Response.Status.CREATED).entity(createdPersona).build(); 
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("{\"message\": \"Error  persona: " + e.getMessage() + "\"}")
                    .build();
        }
    }


    @POST
    @Path("/crearPersona")
    @Consumes(MediaType.APPLICATION_JSON)  
    @Produces(MediaType.APPLICATION_JSON) 
    public Response createPersona(InfoPersonaDTO personaDTO) {
        try {
            InfoPersonaDTO createdPersona = personaService.save(personaDTO); 
            return Response.status(Response.Status.CREATED).entity(createdPersona).build(); 
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("{\"message\": \"Error  persona: " + e.getMessage() + "\"}")
                    .build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updatePersona(InfoPersonaDTO personaDTO) {
        try {
            InfoPersonaDTO updatedPersona = personaService.update(personaDTO);
            return Response.ok(updatedPersona).build(); 
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("{\"message\": \"Persona not found: " + e.getMessage() + "\"}")
                    .build();
        }
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPersonaById(@PathParam("id") Long id) {
        try {
            InfoPersonaDTO personaDTO = personaService.findById(id);
            if (personaDTO == null) {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("{\"message\": \"Persona not found\"}")
                        .build();
            }
            return Response.ok(personaDTO).build(); 
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("{\"message\": \"Error retrieving persona: " + e.getMessage() + "\"}")
                    .build();
        }
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPersonas() {
        try {
            List<InfoPersonaDTO> personas = personaService.findAll();  
            return Response.ok(personas).build(); 
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("{\"message\": \"Error retrieving personas: " + e.getMessage() + "\"}")
                    .build();
        }
    }
}
