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
@Table(name = "info_usuario", schema = "public")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InfoUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long idUsuario;

    @Column(name = "usuario")
    private String usuario;

    @Column(name = "password")
    private String password;
    
    @Column(name = "estado")
    private String estado;

    @ManyToOne
    @JoinColumn(name = "persona_id")
    private InfoPersona persona;
    
    @ManyToOne
    @JoinColumn(name = "rol_id")
    private AdmiRol rol;
}