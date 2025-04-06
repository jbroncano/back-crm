package com.crm.mapper;

import com.crm.dto.ProformaDetDTO;
import com.crm.model.ProformaDet;

public class ProformaDetMapper {

    public static ProformaDetDTO toDTO(ProformaDet entity) {
        if (entity == null) return null;

        return ProformaDetDTO.builder()
                .idProformaDet(entity.getIdProformaDet())
                .cantidad(entity.getCantidad())
                .estado(entity.getEstado())
                .proformaCab(ProformaCabMapper.toDTO(entity.getProformaCab()))
                .producto(AdmiProductoMapper.toDTO(entity.getProducto()))
                .build();
    }

    public static ProformaDet toEntity(ProformaDetDTO dto) {
        if (dto == null) return null;

        return ProformaDet.builder()
                .idProformaDet(dto.getIdProformaDet())
                .cantidad(dto.getCantidad())
                .estado(dto.getEstado())
                .proformaCab(ProformaCabMapper.toEntity(dto.getProformaCab()))
                .producto(AdmiProductoMapper.toEntity(dto.getProducto()))
                .build();
    }
}