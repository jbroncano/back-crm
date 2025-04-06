package com.crm.mapper;



import com.crm.dto.AdmiRolDTO;
import com.crm.model.AdmiRol;

public class AdmiRolMapper {

    public static AdmiRolDTO toDTO(AdmiRol entity) {
        if (entity == null) return null;

        return AdmiRolDTO.builder()
                .idRol(entity.getIdRol())
                .nombre(entity.getNombre())
                .descripcion(entity.getDescripcion())
                .estado(entity.getEstado())
                .build();
    }

    public static AdmiRol toEntity(AdmiRolDTO dto) {
        if (dto == null) return null;

        return AdmiRol.builder()
                .idRol(dto.getIdRol())
                .nombre(dto.getNombre())
                .descripcion(dto.getDescripcion())
                .estado(dto.getEstado())
                .build();
    }
}