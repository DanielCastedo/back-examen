package com.phegondev.usersmanagementsystem.controller;

import com.phegondev.usersmanagementsystem.entity.Sistemaacademico;
import com.phegondev.usersmanagementsystem.service.SistemaacademicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sistemasacademicos")
public class SistemaacademicoController {

    @Autowired
    private SistemaacademicoService sistemaacademicoService;

    @GetMapping
    public List<Sistemaacademico> getAllSistemasacademicos() {
        return sistemaacademicoService.getAllSistemasacademicos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sistemaacademico> getSistemaacademicoById(@PathVariable Integer id) {
        Optional<Sistemaacademico> sistemaacademico = sistemaacademicoService.getSistemaacademicoById(id);
        return sistemaacademico.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Sistemaacademico createSistemaacademico(@RequestBody Sistemaacademico sistemaacademico) {
        return sistemaacademicoService.createSistemaacademico(sistemaacademico);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sistemaacademico> updateSistemaacademico(@PathVariable Integer id, @RequestBody Sistemaacademico sistemaacademicoDetails) {
        Optional<Sistemaacademico> sistemaacademico = sistemaacademicoService.updateSistemaacademico(id, sistemaacademicoDetails);
        return sistemaacademico.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSistemaacademico(@PathVariable Integer id) {
        if (sistemaacademicoService.getSistemaacademicoById(id).isPresent()) {
            sistemaacademicoService.deleteSistemaacademico(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
