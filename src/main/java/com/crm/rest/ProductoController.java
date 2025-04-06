package com.crm.rest;


import com.crm.dto.AdmiProductoDTO;
import com.crm.service.IAdmiProductoService;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/producto")
public class ProductoController {

    @Inject
    IAdmiProductoService productoService;


    @POST
    @Consumes(MediaType.APPLICATION_JSON) 
    @Produces(MediaType.APPLICATION_JSON)  
    public Response createProducto(AdmiProductoDTO productoDTO) {
        try {
            AdmiProductoDTO createdProducto = productoService.save(productoDTO); 
            return Response.status(Response.Status.CREATED).entity(createdProducto).build(); 
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("{\"message\": \"Error  producto: " + e.getMessage() + "\"}")
                    .build();
        }
    }

   
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateProducto(AdmiProductoDTO productoDTO) {
        try {
            AdmiProductoDTO updatedProducto = productoService.update(productoDTO);  
            return Response.ok(updatedProducto).build();  
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("{\"message\": \"Producto encontrado: " + e.getMessage() + "\"}")
                    .build();
        }
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProductoById(@PathParam("id") Long id) {
        try {
            AdmiProductoDTO productoDTO = productoService.findById(id); 
            if (productoDTO == null) {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("{\"message\": \"Producto not found\"}")
                        .build();
            }
            return Response.ok(productoDTO).build(); 
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("{\"message\": \"Error  producto: " + e.getMessage() + "\"}")
                    .build();
        }
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllProductos() {
        try {
            List<AdmiProductoDTO> productos = productoService.findAll(); 
            return Response.ok(productos).build(); 
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("{\"message\": \"Error  productos: " + e.getMessage() + "\"}")
                    .build();
        }
    }
}
