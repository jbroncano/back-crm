package com.crm.service;

import java.util.List;

import com.crm.dto.InfoPersonaDTO;

public interface IInfoPersonaService {
    InfoPersonaDTO save(InfoPersonaDTO entity);
    InfoPersonaDTO update(InfoPersonaDTO entity);
    InfoPersonaDTO findById(Object entityId);
    void delete(InfoPersonaDTO entity);
    List<InfoPersonaDTO> findAll();
}
