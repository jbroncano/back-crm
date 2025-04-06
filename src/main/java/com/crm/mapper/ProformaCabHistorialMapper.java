package com.crm.mapper;


import com.crm.dto.ProformaCabHistorialDTO;
import com.crm.model.ProformaCabHistorial;

public class ProformaCabHistorialMapper {

    public static ProformaCabHistorialDTO toDTO(ProformaCabHistorial entity) {
        if (entity == null) return null;

        return ProformaCabHistorialDTO.builder()
                .id(entity.getProformaCabHistorialId())
                .estadoActual(entity.getEstadoActual())
                .nuevoEstado(entity.getNuevoEstado())
                .observacion(entity.getObservacion())
                .proformaCab(ProformaCabMapper.toDTO(entity.getProformaCab()))
                .feCreacion(entity.getFeCreacion())
                .build();
    }

    public static ProformaCabHistorial toEntity(ProformaCabHistorialDTO dto) {
        if (dto == null) return null;

        return ProformaCabHistorial.builder()
                .proformaCabHistorialId(dto.getId())
                .estadoActual(dto.getEstadoActual())
                .nuevoEstado(dto.getNuevoEstado())
                .observacion(dto.getObservacion())
                .proformaCab(ProformaCabMapper.toEntity(dto.getProformaCab()))
                .feCreacion(dto.getFeCreacion()) 
                .build();
    }
}
