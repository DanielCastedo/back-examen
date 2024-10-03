package com.phegondev.usersmanagementsystem.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "modulos")
@Data
public class Modulo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false, unique = true)
    private String nro;
    @Column(nullable = false)
    private Double latitud; // Nuevo campo

    @Column(nullable = false)
    private Double longitud; // Nuevo campo

    public Modulo() {
    }

    public Modulo(Integer id, String nombre, String nro) {
        this.id = id;
        this.nombre = nombre;
        this.nro = nro;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNro() {
        return nro;
    }

    public void setNro(String nro) {
        this.nro = nro;
    }
}
