package com.crm.service;

import java.util.List;

import com.crm.dto.ProformaCabHistorialDTO;

public interface IProformaCabHistorialService {

	   ProformaCabHistorialDTO save(ProformaCabHistorialDTO entity);
	   ProformaCabHistorialDTO update(ProformaCabHistorialDTO entity);
	   ProformaCabHistorialDTO findById(Object entityId);
	   void delete(ProformaCabHistorialDTO entity);
	   List<ProformaCabHistorialDTO> findAll();
}
