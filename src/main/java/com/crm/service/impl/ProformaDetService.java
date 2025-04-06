package com.crm.service.impl;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

import com.crm.dao.ProformaDetDAO;
import com.crm.dto.ProformaDetDTO;
import com.crm.mapper.ProformaDetMapper;
import com.crm.model.ProformaDet;
import com.crm.service.IProformaDetService;


@Stateless
public class ProformaDetService implements IProformaDetService {

    @Inject
    private ProformaDetDAO dao;

    @Override
    public ProformaDetDTO save(ProformaDetDTO dto) {
        ProformaDet entity = ProformaDetMapper.toEntity(dto);
        ProformaDetDTO res=ProformaDetMapper.toDTO(dao.save(entity)) ;
        return res;
    }

    @Override
    public ProformaDetDTO update(ProformaDetDTO dto) {
        ProformaDet entity = ProformaDetMapper.toEntity(dto);
        ProformaDet updated = dao.update(entity);
        return ProformaDetMapper.toDTO(updated);
    }

    @Override
    public ProformaDetDTO findById(Object id) {
        return ProformaDetMapper.toDTO(dao.findById((Long) id));
    }

    @Override
    public void delete(ProformaDetDTO dto) {
        ProformaDet entity = ProformaDetMapper.toEntity(dto);
        dao.delete(entity);
    }

    @Override
    public List<ProformaDetDTO> findAll() {
        return dao.findAll().stream()
                .map(ProformaDetMapper::toDTO)
                .collect(Collectors.toList());
    }

	@Override
	public List<ProformaDetDTO> findEstadoByCabeceraId(Long cabeceraId,String estado) {
	      return dao.findEstadoByCabeceraId(cabeceraId,estado).stream()
	                .map(ProformaDetMapper::toDTO)
	                .collect(Collectors.toList());
	}
}

