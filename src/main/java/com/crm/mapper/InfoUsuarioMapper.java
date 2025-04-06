package com.crm.mapper;

import com.crm.dto.InfoUsuarioDTO;
import com.crm.model.InfoUsuario;

public class InfoUsuarioMapper {

    public static InfoUsuarioDTO toDTO(InfoUsuario entity) {
        if (entity == null) return null;

        return InfoUsuarioDTO.builder()
                .idUsuario(entity.getIdUsuario())
                .usuario(entity.getUsuario())
                .password(entity.getPassword())
                .estado(entity.getEstado())
                .persona(InfoPersonaMapper.toDTO(entity.getPersona()))
                .rol(AdmiRolMapper.toDTO(entity.getRol()))
                .build();
    }

    public static InfoUsuario toEntity(InfoUsuarioDTO dto) {
        if (dto == null) return null;

        return InfoUsuario.builder()
                .idUsuario(dto.getIdUsuario())
                .usuario(dto.getUsuario())
                .password(dto.getPassword())
                .estado(dto.getEstado())
                .persona(InfoPersonaMapper.toEntity(dto.getPersona()))
                .rol(AdmiRolMapper.toEntity(dto.getRol()))
                .build();
    }
}
