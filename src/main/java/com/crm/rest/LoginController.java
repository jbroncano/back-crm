package com.crm.rest;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

import com.crm.dto.InfoUsuarioDTO;
import com.crm.service.ILoginService;

import jakarta.inject.Inject;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.core.Response;

@Path("/login") 
public class LoginController {

	@Inject
	ILoginService loginService;
	
    @POST 
    public Response login(@FormParam("username") String username, @FormParam("password") String password) {
    	InfoUsuarioDTO infoUsuarioDTO= loginService.inicioSession(username, password);
    	if(infoUsuarioDTO!=null) {
            return Response.ok(infoUsuarioDTO).type("application/json").build();
    	} else {
            return Response.status(Response.Status.UNAUTHORIZED)
                    .entity("Credenciales invalidas.")
                    .build();
        }
    }
}

