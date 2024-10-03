package com.phegondev.usersmanagementsystem.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "sesion")
@Data
public class Sesion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String link;
    private String nombre;

    // Relación Many-to-One con la tabla de OurUsers
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private OurUsers ourUser;

}
