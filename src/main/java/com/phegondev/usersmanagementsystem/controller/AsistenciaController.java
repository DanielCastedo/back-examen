package com.phegondev.usersmanagementsystem.controller;

import com.phegondev.usersmanagementsystem.entity.Asistencia;
import com.phegondev.usersmanagementsystem.service.AsistenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/asistencias")
public class AsistenciaController {

    @Autowired
    private AsistenciaService asistenciaService;

    @GetMapping
    public List<Asistencia> getAllAsistencias() {
        return asistenciaService.getAllAsistencias();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Asistencia> getAsistenciaById(@PathVariable Integer id) {
        Optional<Asistencia> asistencia = asistenciaService.getAsistenciaById(id);
        return asistencia.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Asistencia createAsistencia(@RequestBody Asistencia asistencia) {
        return asistenciaService.createAsistencia(asistencia);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Asistencia> updateAsistencia(@PathVariable Integer id, @RequestBody Asistencia asistenciaDetails) {
        Optional<Asistencia> asistencia = asistenciaService.updateAsistencia(id, asistenciaDetails);
        return asistencia.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAsistencia(@PathVariable Integer id) {
        if (asistenciaService.getAsistenciaById(id).isPresent()) {
            asistenciaService.deleteAsistencia(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
