package com.phegondev.usersmanagementsystem.controller;


import com.phegondev.usersmanagementsystem.entity.Facultad;
import com.phegondev.usersmanagementsystem.service.FacultadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/facultades")
public class FacultadController {

    @Autowired
    private FacultadService facultadService;

    @GetMapping
    public List<Facultad> getAllFacultades() {
        return facultadService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Facultad> getFacultadById(@PathVariable Integer id) {
        Optional<Facultad> facultad = facultadService.findById(id);
        return facultad.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Facultad createFacultad(@RequestBody Facultad facultad) {
        return facultadService.save(facultad);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Facultad> updateFacultad(@PathVariable Integer id, @RequestBody Facultad updatedFacultad) {
        Optional<Facultad> facultad = facultadService.findById(id);
        if (facultad.isPresent()) {
            updatedFacultad.setId(id);
            return ResponseEntity.ok(facultadService.save(updatedFacultad));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFacultad(@PathVariable Integer id) {
        facultadService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
