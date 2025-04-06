package com.crm.mapper;


import com.crm.dto.AdmiProductoDTO;
import com.crm.model.AdmiProducto;

public class AdmiProductoMapper {

    public static AdmiProductoDTO toDTO(AdmiProducto entity) {
        if (entity == null) return null;

        return AdmiProductoDTO.builder()
                .idProducto(entity.getIdProducto())
                .nombre(entity.getNombre())
                .descripcion(entity.getDescripcion())
                .precio(entity.getPrecio())
                .estado(entity.getEstado())
                .build();
    }

    public static AdmiProducto toEntity(AdmiProductoDTO dto) {
        if (dto == null) return null;

        return AdmiProducto.builder()
                .idProducto(dto.getIdProducto())
                .nombre(dto.getNombre())
                .descripcion(dto.getDescripcion())
                .precio(dto.getPrecio())
                .estado(dto.getEstado())
                .build();
    }
}