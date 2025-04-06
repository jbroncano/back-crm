package com.crm.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.crm.dao.AdmiRolDAO;
import com.crm.dto.AdmiRolDTO;
import com.crm.mapper.AdmiRolMapper;
import com.crm.model.AdmiRol;
import com.crm.service.IAdmiRolService;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class AdmiRolService implements IAdmiRolService {

    @Inject
    private AdmiRolDAO dao;

    @Override
    public AdmiRolDTO save(AdmiRolDTO dto) {
        AdmiRol entity = AdmiRolMapper.toEntity(dto);
        dao.save(entity);
        return AdmiRolMapper.toDTO(entity);
    }

    @Override
    public AdmiRolDTO update(AdmiRolDTO dto) {
        AdmiRol entity = AdmiRolMapper.toEntity(dto);
        AdmiRol updated = dao.update(entity);
        return AdmiRolMapper.toDTO(updated);
    }

    @Override
    public AdmiRolDTO findById(Object id) {
        return AdmiRolMapper.toDTO(dao.findById((Long) id));
    }

    @Override
    public void delete(AdmiRolDTO dto) {
        AdmiRol entity = AdmiRolMapper.toEntity(dto);
        dao.delete(entity);
    }

    @Override
    public List<AdmiRolDTO> findAll() {
        return dao.findAll().stream()
                .map(AdmiRolMapper::toDTO)
                .collect(Collectors.toList());
    }
}
