package com.crm.model;

import java.time.LocalDateTime;

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
@Table(name = "proforma_det", schema = "public")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProformaDet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proforma_det")
    private Long idProformaDet;

    @ManyToOne
    @JoinColumn(name = "proforma_cab_id")
    private ProformaCab proformaCab;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private AdmiProducto producto;

    @JoinColumn(name = "cantidad")
    private String cantidad;
    @JoinColumn(name = "estado")
    private String estado;

}
