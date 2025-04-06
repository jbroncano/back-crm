package com.crm.rest;

import com.crm.dto.ProformaCabDTO;
import com.crm.dto.ProformaDTO;
import com.crm.dto.ProformaDetDTO;
import com.crm.service.IProformaCabService;
import com.crm.service.IProformaService;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/proforma")
public class ProformaController {

    @Inject
    IProformaCabService proformaCabService;  
    
    @Inject
    IProformaService proformaService;
    
    
    

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON) 
    public Response createProforma(ProformaDTO proformaCabDTO) {
        try {
        	ProformaDTO createdProforma = proformaService.crearProforma(proformaCabDTO); 
            return Response.status(Response.Status.CREATED).entity(createdProforma).build(); 
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("{\"message\": \"Error  proforma: " + e.getMessage() + "\"}")
                    .build();
        }
    }
    
    
    @POST
    @Path("/buscarDet")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON) 
    public Response findEstadoByCabeceraId(ProformaDTO proformaCabDTO) {
        try {
        	List<ProformaDetDTO> createdProforma = proformaService.findEstadoByCabeceraId(proformaCabDTO); 
            if (createdProforma == null) {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("{\"message\": \"Proforma not found\"}")
                        .build();
            }
        	return Response.status(Response.Status.CREATED).entity(createdProforma).build();  
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("{\"message\": \"Error  proforma: " + e.getMessage() + "\"}")
                    .build();
        }
    }
    

    
    


    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateProforma(ProformaCabDTO proformaCabDTO) {
        try {
            ProformaCabDTO updatedProforma = proformaCabService.update(proformaCabDTO); 
            return Response.ok(updatedProforma).build();  
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("{\"message\": \"Proforma encontrada: " + e.getMessage() + "\"}")
                    .build();
        }
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProformaById(@PathParam("id") Long id) {
        try {
            ProformaCabDTO proformaCabDTO = proformaCabService.findById(id);  
            if (proformaCabDTO == null) {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("{\"message\": \"Proforma not found\"}")
                        .build();
            }
            return Response.ok(proformaCabDTO).build();  
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("{\"message\": \"Error  proforma: " + e.getMessage() + "\"}")
                    .build();
        }
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllProformas() {
        try {
            List<ProformaCabDTO> proformas = proformaCabService.findAll();
            return Response.ok(proformas).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("{\"message\": \"Error  proformas: " + e.getMessage() + "\"}")
                    .build();
        }
    }
}
