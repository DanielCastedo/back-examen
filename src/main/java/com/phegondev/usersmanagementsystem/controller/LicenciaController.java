package com.phegondev.usersmanagementsystem.controller;

import com.phegondev.usersmanagementsystem.entity.Licencia;
import com.phegondev.usersmanagementsystem.service.LicenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/licencias")
public class LicenciaController {

    private final LicenciaService licenciaService;

    @Autowired
    public LicenciaController(LicenciaService licenciaService) {
        this.licenciaService = licenciaService;
    }

    @GetMapping
    public ResponseEntity<List<Licencia>> getAllLicencias() {
        List<Licencia> licencias = licenciaService.getAllLicencias();
        return new ResponseEntity<>(licencias, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Licencia> getLicenciaById(@PathVariable("id") Integer id) {
        Optional<Licencia> licencia = licenciaService.getLicenciaById(id);
        return licencia.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Licencia> createLicencia(@RequestBody Licencia licencia) {
        Licencia createdLicencia = licenciaService.createLicencia(licencia);
        return new ResponseEntity<>(createdLicencia, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Licencia> updateLicencia(@PathVariable("id") Integer id, @RequestBody Licencia licencia) {
        Optional<Licencia> updatedLicencia = licenciaService.updateLicencia(id, licencia);
        return updatedLicencia.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLicencia(@PathVariable("id") Integer id) {
        licenciaService.deleteLicencia(id);
        return ResponseEntity.noContent().build();
    }
}
