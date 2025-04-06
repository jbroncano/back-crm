package com.crm.service.impl;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.List;
import java.util.stream.Collectors;

import com.crm.dao.ProformaCabHistorialDAO;
import com.crm.dto.ProformaCabHistorialDTO;
import com.crm.mapper.ProformaCabHistorialMapper;
import com.crm.model.ProformaCabHistorial;
import com.crm.service.IProformaCabHistorialService;

@Stateless
public class ProformaCabHistorialService implements IProformaCabHistorialService {

    @Inject
    private ProformaCabHistorialDAO dao;

    @Override
    public ProformaCabHistorialDTO save(ProformaCabHistorialDTO dto) {
        ProformaCabHistorial entity = ProformaCabHistorialMapper.toEntity(dto);
        ProformaCabHistorialDTO res=ProformaCabHistorialMapper.toDTO(dao.save(entity)) ;
        return dto;
    }

    @Override
    public ProformaCabHistorialDTO update(ProformaCabHistorialDTO dto) {
        ProformaCabHistorial entity = ProformaCabHistorialMapper.toEntity(dto);
        ProformaCabHistorial updated = dao.update(entity);
        return ProformaCabHistorialMapper.toDTO(updated);
    }

    @Override
    public ProformaCabHistorialDTO findById(Object id) {
        return ProformaCabHistorialMapper.toDTO(dao.findById((Long) id));
    }

    @Override
    public void delete(ProformaCabHistorialDTO dto) {
        ProformaCabHistorial entity = ProformaCabHistorialMapper.toEntity(dto);
        dao.delete(entity);
    }

    @Override
    public List<ProformaCabHistorialDTO> findAll() {
        return dao.findAll().stream()
                .map(ProformaCabHistorialMapper::toDTO)
                .collect(Collectors.toList());
    }
}
