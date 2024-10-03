package com.phegondev.usersmanagementsystem.controller;

import com.phegondev.usersmanagementsystem.entity.Sesion;
import com.phegondev.usersmanagementsystem.service.SesionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sesiones")
public class SesionController {

    @Autowired
    private SesionService sesionService;

    // Crear una nueva sesión
    @PostMapping("/create")
    public ResponseEntity<Sesion> createSesion(@RequestParam String link,
                                               @RequestParam String nombre,
                                               @RequestParam Integer userId) {
        Sesion newSesion = sesionService.createSesion(link, nombre, userId);
        return ResponseEntity.ok(newSesion);
    }

    // Obtener todas las sesiones
    @GetMapping("/all")
    public ResponseEntity<List<Sesion>> getAllSesiones() {
        List<Sesion> sesiones = sesionService.getAllSesiones();
        return ResponseEntity.ok(sesiones);
    }

    // Obtener sesiones por ID de usuario
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Sesion>> getSesionesByUserId(@PathVariable Integer userId) {
        List<Sesion> sesiones = sesionService.getSesionesByUserId(userId);
        return ResponseEntity.ok(sesiones);
    }

    // Eliminar una sesión por su ID
    @DeleteMapping("/delete/{sesionId}")
    public ResponseEntity<Void> deleteSesion(@PathVariable Integer sesionId) {
        sesionService.deleteSesion(sesionId);
        return ResponseEntity.ok().build();
    }
}
