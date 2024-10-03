package com.phegondev.usersmanagementsystem.controller;

import com.phegondev.usersmanagementsystem.entity.Aula;
import com.phegondev.usersmanagementsystem.service.AulaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/aulas")
public class AulaController {

    @Autowired
    private AulaService aulaService;

//    @GetMapping
//    public List<Aula> getAllAulas() {
//        return aulaService.getAllAulas();
//    }

    @GetMapping
    public List<Aula> getAllAulas() {
        List<Aula> aulas = aulaService.getAllAulas();
        // Force loading the modulo in each aula
        for (Aula aula : aulas) {
            aula.setModulo(aula.getModulo());
        }
        return aulas;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aula> getAulaById(@PathVariable Integer id) {
        Optional<Aula> aula = aulaService.getAulaById(id);
        return aula.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Aula createAula(@RequestBody Aula aula, @RequestParam Integer moduloId) {
        return aulaService.createAula(aula, moduloId);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aula> updateAula(@PathVariable Integer id, @RequestBody Aula aulaDetails) {
        Optional<Aula> aula = aulaService.updateAula(id, aulaDetails);
        return aula.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAula(@PathVariable Integer id) {
        if (aulaService.getAulaById(id).isPresent()) {
            aulaService.deleteAula(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
