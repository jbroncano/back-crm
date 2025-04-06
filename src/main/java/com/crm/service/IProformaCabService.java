package com.crm.service;
import java.util.List;

import com.crm.dto.ProformaCabDTO;

public interface IProformaCabService {
    ProformaCabDTO save(ProformaCabDTO entity);
    ProformaCabDTO update(ProformaCabDTO entity);
    ProformaCabDTO findById(Object entityId);
    void delete(ProformaCabDTO entity);
    List<ProformaCabDTO> findAll();
}
