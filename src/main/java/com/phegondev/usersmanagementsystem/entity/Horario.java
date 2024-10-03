package com.phegondev.usersmanagementsystem.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "horarios")
@Data
public class Horario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String dia;

    @Column(nullable = false)
    private Time horainicio;

    @Column(nullable = false)
    private Time horafin;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "grupo_id", nullable = false)  // Asegúrate de que 'aula_id' es el nombre correcto de la columna FK en la tabla 'horarios'
    private Grupo grupo;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "aula_id", nullable = false)  // Asegúrate de que 'aula_id' es el nombre correcto de la columna FK en la tabla 'horarios'
    private Aula aula;

}
