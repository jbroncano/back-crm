package com.crm.service;

import java.util.List;

import com.crm.dto.AdmiProductoDTO;

public interface IAdmiProductoService {
    AdmiProductoDTO save(AdmiProductoDTO entity);
    AdmiProductoDTO update(AdmiProductoDTO entity);
    AdmiProductoDTO findById(Object entityId);
    void delete(AdmiProductoDTO entity);
    List<AdmiProductoDTO> findAll();
}
