package com.phegondev.usersmanagementsystem.controller;

import com.phegondev.usersmanagementsystem.entity.Materia;
import com.phegondev.usersmanagementsystem.service.MateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/materias")
public class MateriaController {

    @Autowired
    private MateriaService materiaService;

    @GetMapping
    public List<Materia> getAllMaterias() {
        return materiaService.getAllMaterias();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Materia> getMateriaById(@PathVariable Integer id) {
        Optional<Materia> materia = materiaService.getMateriaById(id);
        return materia.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Materia createMateria(@RequestBody    Materia materia) {
        return materiaService.createMateria(materia);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Materia> updateMateria(@PathVariable Integer id, @RequestBody Materia materiaDetails) {
        Optional<Materia> materia = materiaService.updateMateria(id, materiaDetails);
        return materia.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMateria(@PathVariable Integer id) {
        if (materiaService.getMateriaById(id).isPresent()) {
            materiaService.deleteMateria(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
