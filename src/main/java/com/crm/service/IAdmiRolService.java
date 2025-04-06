package com.crm.service;

import java.util.List;

import com.crm.dto.AdmiRolDTO;

public interface IAdmiRolService {
    AdmiRolDTO save(AdmiRolDTO entity);
    AdmiRolDTO update(AdmiRolDTO entity);
    AdmiRolDTO findById(Object entityId);
    void delete(AdmiRolDTO entity);
    List<AdmiRolDTO> findAll();
}
