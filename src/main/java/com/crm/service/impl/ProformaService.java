package com.crm.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.crm.dto.ProformaCabDTO;
import com.crm.dto.ProformaDTO;
import com.crm.dto.ProformaDetDTO;
import com.crm.service.IProformaCabService;
import com.crm.service.IProformaDetService;
import com.crm.service.IProformaService;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class ProformaService implements IProformaService{

	@Inject
	IProformaCabService proformaCabService;
	
	@Inject
	IProformaDetService proformaDetService;
	
	@Override
	public ProformaDTO crearProforma(ProformaDTO proforma) {
		ProformaDTO res=new ProformaDTO(); 
		ProformaCabDTO newPro=proformaCabService.save(proforma.getProformaCabDTO());
		res.setProformaCabDTO(newPro);
		res.setLstProformaDetDTO(new ArrayList<ProformaDetDTO>());
		for (ProformaDetDTO det : proforma.getLstProformaDetDTO() ) {
			det.setProformaCab(newPro);
			res.getLstProformaDetDTO().add(proformaDetService.save(det));
		}
		
		return res;
	}

	@Override
	public ProformaDTO actualizarProforma(ProformaDTO proforma) {
		ProformaDTO res=new ProformaDTO(); 
		ProformaCabDTO newPro=proformaCabService.update(proforma.getProformaCabDTO());
		res.setProformaCabDTO(newPro);
		res.setLstProformaDetDTO(new ArrayList<ProformaDetDTO>());
		for (ProformaDetDTO det : proforma.getLstProformaDetDTO() ) {
			det.setProformaCab(newPro);
			res.getLstProformaDetDTO().add(proformaDetService.update(det));
		}
		
		for (ProformaDetDTO det : proforma.getLstDelProformaDetDTO() ) {
			det.setEstado("Inactivo");
			res.getLstProformaDetDTO().add(proformaDetService.update(det));
		}
		
		return res;
	}

	@Override
	public List<ProformaDetDTO> findEstadoByCabeceraId(ProformaDTO proforma) {
		return proformaDetService.findEstadoByCabeceraId(proforma.getProformaCabDTO().getIdProformaCab(), proforma.getProformaCabDTO().getEstado());
	}
	
	
	
	


}
