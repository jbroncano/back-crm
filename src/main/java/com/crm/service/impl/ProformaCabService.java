package com.crm.service.impl;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.List;
import java.util.stream.Collectors;

import com.crm.dao.ProformaCabDAO;
import com.crm.dto.ProformaCabDTO;
import com.crm.mapper.ProformaCabMapper;
import com.crm.model.ProformaCab;
import com.crm.service.IProformaCabService;

@Stateless
public class ProformaCabService implements IProformaCabService {

    @Inject
    private ProformaCabDAO dao;

    @Override
    public ProformaCabDTO save(ProformaCabDTO dto) {
        ProformaCab entity = ProformaCabMapper.toEntity(dto);
        ProformaCabDTO resentity =ProformaCabMapper.toDTO(dao.save(entity)) ;
        return resentity;
    }

    @Override
    public ProformaCabDTO update(ProformaCabDTO dto) {
        ProformaCab entity = ProformaCabMapper.toEntity(dto);
        ProformaCab updated = dao.update(entity);
        return ProformaCabMapper.toDTO(updated);
    }

    @Override
    public ProformaCabDTO findById(Object id) {
        return ProformaCabMapper.toDTO(dao.findById((Long) id));
    }

    @Override
    public void delete(ProformaCabDTO dto) {
        ProformaCab entity = ProformaCabMapper.toEntity(dto);
        dao.delete(entity);
    }

    @Override
    public List<ProformaCabDTO> findAll() {
        return dao.findAll().stream()
                .map(ProformaCabMapper::toDTO)
                .collect(Collectors.toList());
    }
}
