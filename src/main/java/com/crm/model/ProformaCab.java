package com.crm.model;

import java.time.LocalDateTime;
import java.util.Date;

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
@Table(name = "proforma_cab", schema = "public")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProformaCab {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proforma_cab")
    private Long idProformaCab;

    private String numero;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fe_validez")
    private Date feValidez;

    @Column(name = "condicion_pago")
    private String condicionPago;

    @Column(name = "forma_pago")
    private String formaPago;


    @ManyToOne
    @JoinColumn(name = "persona_id")
    private InfoPersona persona;

    @Column(name = "estado")
    private String estado;

    @Column(name = "impuesto")
    private Double impuesto;
    
    @Column(name = "descuento")
    private Double descuento;
}