package com.crm.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.crm.dao.AdmiProductoDAO;
import com.crm.dto.AdmiProductoDTO;
import com.crm.mapper.AdmiProductoMapper;
import com.crm.model.AdmiProducto;
import com.crm.service.IAdmiProductoService;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class AdmiProductoService implements IAdmiProductoService {

    @Inject
    private AdmiProductoDAO dao;


    @Override
    public AdmiProductoDTO save(AdmiProductoDTO dto) {
        AdmiProducto entity = AdmiProductoMapper.toEntity(dto);
        dao.save(entity);
        return AdmiProductoMapper.toDTO(entity);
    }

    @Override
    public AdmiProductoDTO update(AdmiProductoDTO dto) {
        AdmiProducto entity = AdmiProductoMapper.toEntity(dto);
        AdmiProducto updated = dao.update(entity);
        return AdmiProductoMapper.toDTO(updated);
    }

    @Override
    public AdmiProductoDTO findById(Object id) {
        return AdmiProductoMapper.toDTO(dao.findById((Long) id));
    }

    @Override
    public void delete(AdmiProductoDTO dto) {
        AdmiProducto entity = AdmiProductoMapper.toEntity(dto);
        dao.delete(entity);
    }

    @Override
    public List<AdmiProductoDTO> findAll() {
    	  return dao.findAll().stream()
                  .map(AdmiProductoMapper::toDTO)
                  .collect(Collectors.toList());
    }
}