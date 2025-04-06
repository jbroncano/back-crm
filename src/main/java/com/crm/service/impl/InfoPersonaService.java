package com.crm.service.impl;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

import com.crm.dao.InfoPersonaDAO;
import com.crm.dto.InfoPersonaDTO;
import com.crm.mapper.InfoPersonaMapper;
import com.crm.model.InfoPersona;
import com.crm.service.IInfoPersonaService;

@Stateless
public class InfoPersonaService implements IInfoPersonaService {

    @Inject
    private InfoPersonaDAO dao;

    @Override
    public InfoPersonaDTO save(InfoPersonaDTO dto) {
        InfoPersona entity = InfoPersonaMapper.toEntity(dto);
        dao.save(entity);
        return InfoPersonaMapper.toDTO(entity);
    }

    @Override
    public InfoPersonaDTO update(InfoPersonaDTO dto) {
        InfoPersona entity = InfoPersonaMapper.toEntity(dto);
        InfoPersona updated = dao.update(entity);
        return InfoPersonaMapper.toDTO(updated);
    }

    @Override
    public InfoPersonaDTO findById(Object id) {
        return InfoPersonaMapper.toDTO(dao.findById((Long) id));
    }

    @Override
    public void delete(InfoPersonaDTO dto) {
        InfoPersona entity = InfoPersonaMapper.toEntity(dto);
        dao.delete(entity);
    }

    @Override
    public List<InfoPersonaDTO> findAll() {
        return dao.findAll().stream()
                  .map(InfoPersonaMapper::toDTO)
                  .collect(Collectors.toList());
    }
}
