package com.phegondev.usersmanagementsystem.entity;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "asistencias")
@Data
public class Asistencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String descripcion;

    @Column(nullable = false)
    private Time hora;

    @Column(nullable = false)
    private Date fecha;

    @Column(nullable = false)
    private Time tiempo;

    @Column(nullable = false)
    private String estado;

    @Column(nullable = false)
    private Double latitud; // Nuevo campo

    @Column(nullable = false)
    private Double longitud; // Nuevo campo

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "grupo_id", nullable = true)
    private Grupo grupo;

}
