package com.crm.service;

import java.util.List;

import com.crm.dto.ProformaDetDTO;
import com.crm.model.ProformaDet;

public interface IProformaDetService {
    ProformaDetDTO save(ProformaDetDTO entity);
    ProformaDetDTO update(ProformaDetDTO entity);
    ProformaDetDTO findById(Object entityId);
    void delete(ProformaDetDTO entity);
    List<ProformaDetDTO> findAll();
     List<ProformaDetDTO> findEstadoByCabeceraId(Long cabeceraId,String estado);
}
