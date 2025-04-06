package com.crm.service;

import java.util.List;

import com.crm.dto.ProformaDTO;
import com.crm.dto.ProformaDetDTO;

public interface IProformaService {
	ProformaDTO crearProforma(ProformaDTO proforma);
	

 ProformaDTO actualizarProforma(ProformaDTO proforma);
 
 List<ProformaDetDTO> findEstadoByCabeceraId(ProformaDTO proforma);
 
}
