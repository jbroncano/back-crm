package com.crm.service.impl;

import com.crm.dto.InfoUsuarioDTO;
import com.crm.service.IInfoUsuarioService;
import com.crm.service.ILoginService;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class LoginService  implements ILoginService{
	
	@Inject
	IInfoUsuarioService infoUsuarioService;

	@Override
	public InfoUsuarioDTO inicioSession(String usuario, String password) {
	    try {
	        InfoUsuarioDTO usuarioDTO = infoUsuarioService.findByName(usuario);

	        if (usuarioDTO != null && usuarioDTO.getIdUsuario() != null) {
	            if (usuarioDTO.getPassword().equals(password)) {
	                return usuarioDTO; 
	            } else {
	                throw new IllegalArgumentException("Contraseña incorrecta para el usuario: " + usuario);
	            }
	        } else {
	            throw new IllegalArgumentException("El usuario no existe: " + usuario);
	        }
	    }catch (Exception e) {
	        System.err.println("Error inesperado: " + e.getMessage());
	        e.printStackTrace();
	        return null; 
	    }
	}
	


}
