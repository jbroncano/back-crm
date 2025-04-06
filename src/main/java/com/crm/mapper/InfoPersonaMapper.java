package com.crm.mapper;

import com.crm.dto.InfoPersonaDTO;
import com.crm.model.InfoPersona;

public class InfoPersonaMapper {

    public static InfoPersonaDTO toDTO(InfoPersona entity) {
        if (entity == null) return null;

        return InfoPersonaDTO.builder()
                .idPersona(entity.getIdPersona())
                .identificacion(entity.getIdentificacion())
                .nombre(entity.getNombre())
                .apellido(entity.getApellido())
                .direccion(entity.getDireccion())
                .estado(entity.getEstado())
                .razonSocial(entity.getRazonSocial())
                .build();
    }

    public static InfoPersona toEntity(InfoPersonaDTO dto) {
        if (dto == null) return null;

        return InfoPersona.builder()
                .idPersona(dto.getIdPersona())
                .identificacion(dto.getIdentificacion())
                .nombre(dto.getNombre())
                .apellido(dto.getApellido())
                .direccion(dto.getDireccion())
                .estado(dto.getEstado())
                .razonSocial(dto.getRazonSocial())
                .build();
    }
}