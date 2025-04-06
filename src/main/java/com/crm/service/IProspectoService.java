package com.crm.service;

import com.crm.dto.InfoPersonaDTO;
import com.crm.dto.ProspectoDTO;

public interface IProspectoService {
	InfoPersonaDTO crateProspecto(ProspectoDTO prospectoDTO);
	InfoPersonaDTO actualizarProspecto(ProspectoDTO prospectoDTO);
}
