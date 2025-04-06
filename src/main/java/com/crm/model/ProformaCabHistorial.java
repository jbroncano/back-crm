package com.crm.model;


import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "proforma_cab_historial", schema = "public")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProformaCabHistorial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "proforma_cab_historial_id")
    private Long proformaCabHistorialId;

    @ManyToOne
    @JoinColumn(name = "proforma_cab_id")
    private ProformaCab proformaCab;

    @Column(name = "estado_actual")
    private String estadoActual;

    @Column(name = "nuevo_estado")
    private String nuevoEstado;

    private String observacion;

    @Column(name = "usr_creacion")
    private String usrCreacion;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @Column(name = "fe_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime feCreacion;
}
