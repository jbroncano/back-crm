package com.crm.service.impl;



import com.crm.dto.AdmiRolDTO;
import com.crm.dto.InfoPersonaDTO;
import com.crm.dto.InfoUsuarioDTO;
import com.crm.dto.ProspectoDTO;
import com.crm.rest.RolController;
import com.crm.service.IAdmiRolService;
import com.crm.service.IInfoPersonaService;
import com.crm.service.IInfoUsuarioService;
import com.crm.service.IProspectoService;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class ProspectService implements IProspectoService {

	@Inject
	private IInfoPersonaService infoPersonaService;
	
	@Inject
	private IInfoUsuarioService infoUsuarioService;
	
	
	@Inject
	private IAdmiRolService admiRolService;
	
	
	@Override
	public InfoPersonaDTO crateProspecto(ProspectoDTO prospectoDTO) {

		InfoPersonaDTO resPersona=   infoPersonaService.save(prospectoDTO.getInfoPersonaDTO());
		
		if(prospectoDTO.getRolId()!=null) {
			AdmiRolDTO rol=admiRolService.findById(prospectoDTO.getRolId());
			if(rol!=null) {
				InfoUsuarioDTO usuario=InfoUsuarioDTO.builder()
						.usuario(prospectoDTO.getInfoUsuarioDTO().getUsuario())
						.password(prospectoDTO.getInfoUsuarioDTO().getPassword())
						.rol(rol)
						.persona(resPersona)
						.build();
				infoUsuarioService.save(usuario);
			}
		}

		
		return resPersona;
	}
	
	
	@Override
	public InfoPersonaDTO actualizarProspecto(ProspectoDTO prospectoDTO) {
		AdmiRolDTO rol=admiRolService.findById(prospectoDTO.getRolId());

		InfoPersonaDTO resPersona=   infoPersonaService.update(prospectoDTO.getInfoPersonaDTO());
		
		if(rol!=null) {
			InfoUsuarioDTO usuario=InfoUsuarioDTO.builder()
					.idUsuario(prospectoDTO.getInfoUsuarioDTO().getIdUsuario())
					.usuario(prospectoDTO.getInfoUsuarioDTO().getUsuario())
					.password(prospectoDTO.getInfoUsuarioDTO().getPassword())
					.rol(rol)
					.persona(resPersona)
					.build();
			infoUsuarioService.update(usuario);
		}

		
		return resPersona;
	}

	
}
