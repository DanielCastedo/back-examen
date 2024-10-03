package com.phegondev.usersmanagementsystem.controller;

import com.phegondev.usersmanagementsystem.entity.Modulo;
import com.phegondev.usersmanagementsystem.service.ModuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/modulos")
public class ModuloController {

    @Autowired
    private ModuloService moduloService;

    @GetMapping
    public List<Modulo> getAllModulos() {
        return moduloService.getAllModulos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Modulo> getModuloById(@PathVariable Integer id) {
        Optional<Modulo> modulo = moduloService.getModuloById(id);
        return modulo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Modulo createModulo(@RequestBody Modulo modulo) {
        return moduloService.createModulo(modulo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Modulo> updateModulo(@PathVariable Integer id, @RequestBody Modulo moduloDetails) {
        Optional<Modulo> modulo = moduloService.updateModulo(id, moduloDetails);
        return modulo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteModulo(@PathVariable Integer id) {
        if (moduloService.getModuloById(id).isPresent()) {
            moduloService.deleteModulo(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
