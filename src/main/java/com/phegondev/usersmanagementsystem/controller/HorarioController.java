package com.phegondev.usersmanagementsystem.controller;

import com.phegondev.usersmanagementsystem.entity.Horario;
import com.phegondev.usersmanagementsystem.service.HorarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/horarios")
public class HorarioController {

    @Autowired
    private HorarioService horarioService;

    @GetMapping
    public List<Horario> getAllHorarios() {
        return horarioService.getAllHorarios();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Horario> getHorarioById(@PathVariable Integer id) {
        Optional<Horario> horario = horarioService.getHorarioById(id);
        return horario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Horario createHorario(@RequestBody Horario horario) {
        return horarioService.createHorario(horario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Horario> updateHorario(@PathVariable Integer id, @RequestBody Horario horarioDetails) {
        Optional<Horario> horario = horarioService.updateHorario(id, horarioDetails);
        return horario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHorario(@PathVariable Integer id) {
        if (horarioService.getHorarioById(id).isPresent()) {
            horarioService.deleteHorario(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
