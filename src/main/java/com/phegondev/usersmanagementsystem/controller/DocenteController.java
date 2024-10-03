package com.phegondev.usersmanagementsystem.controller;

import com.phegondev.usersmanagementsystem.entity.Docente;
import com.phegondev.usersmanagementsystem.service.DocenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/docentes")
public class DocenteController {

    @Autowired
    private DocenteService docenteService;

    @GetMapping
    public List<Docente> getAllDocentes() {
        return docenteService.getAllDocentes();
    }

    @PostMapping
    public ResponseEntity<Docente> saveDocente(@RequestBody Docente docente) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();
        Docente savedDocente = docenteService.saveDocente(docente, userEmail);
        return new ResponseEntity<>(savedDocente, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Docente> updateDocente(@PathVariable Integer id, @RequestBody Docente docente) {
        Docente updatedDocente = docenteService.updateDocente(id, docente);
        return ResponseEntity.ok(updatedDocente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDocente(@PathVariable Integer id) {
        docenteService.deleteDocente(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Docente> getDocenteById(@PathVariable Integer id) {
        Docente docente = docenteService.getDocenteById(id);
        return ResponseEntity.ok(docente);
    }
}