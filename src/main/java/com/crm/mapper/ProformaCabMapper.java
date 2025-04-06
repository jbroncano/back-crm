package com.crm.mapper;



import com.crm.dto.ProformaCabDTO;
import com.crm.model.ProformaCab;

public class ProformaCabMapper {

    public static ProformaCabDTO toDTO(ProformaCab entity) {
        if (entity == null) return null;

        return ProformaCabDTO.builder()
                .idProformaCab(entity.getIdProformaCab())
                .numero(entity.getNumero())
                .feValidez(entity.getFeValidez())
                .condicionPago(entity.getCondicionPago())
                .formaPago(entity.getFormaPago())
                .estado(entity.getEstado())
                .impuesto(entity.getImpuesto())
                .descuento(entity.getDescuento())
                .persona(InfoPersonaMapper.toDTO(entity.getPersona()))
                .build();
    }

    public static ProformaCab toEntity(ProformaCabDTO dto) {
        if (dto == null) return null;

        return ProformaCab.builder()
                .idProformaCab(dto.getIdProformaCab())
                .numero(dto.getNumero())
                .feValidez(dto.getFeValidez())
                .condicionPago(dto.getCondicionPago())
                .formaPago(dto.getFormaPago())
                .estado(dto.getEstado())
                .impuesto(dto.getImpuesto())
                .descuento(dto.getDescuento())
                .persona(InfoPersonaMapper.toEntity(dto.getPersona()))
                .build();
    }
}
