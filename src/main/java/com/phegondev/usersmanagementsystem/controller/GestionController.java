package com.phegondev.usersmanagementsystem.controller;

import com.phegondev.usersmanagementsystem.entity.Gestion;
import com.phegondev.usersmanagementsystem.service.GestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/gestiones")
public class GestionController {

    @Autowired
    private GestionService gestionService;

    @GetMapping
    public List<Gestion> getAllGestions() {
        return gestionService.getAllGestions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Gestion> getGestionById(@PathVariable Integer id) {
        Optional<Gestion> gestion = gestionService.getGestionById(id);
        return gestion.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Gestion createGestion(@RequestBody Gestion gestion) {
        return gestionService.createGestion(gestion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Gestion> updateGestion(@PathVariable Integer id, @RequestBody Gestion gestionDetails) {
        Optional<Gestion> gestion = gestionService.updateGestion(id, gestionDetails);
        return gestion.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGestion(@PathVariable Integer id) {
        if (gestionService.getGestionById(id).isPresent()) {
            gestionService.deleteGestion(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
