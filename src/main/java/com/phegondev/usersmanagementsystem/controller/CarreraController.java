package com.phegondev.usersmanagementsystem.controller;

import com.phegondev.usersmanagementsystem.entity.Carrera;
import com.phegondev.usersmanagementsystem.service.CarreraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/carreras")
public class CarreraController {

    @Autowired
    private CarreraService carreraService;

    @GetMapping
    public List<Carrera> getAllCarreras() {
        return carreraService.getAllCarreras();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Carrera> getCarreraById(@PathVariable Integer id) {
        Optional<Carrera> carrera = carreraService.getCarreraById(id);
        return carrera.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Carrera createCarrera(@RequestBody Carrera carrera) {
        return carreraService.createCarrera(carrera);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Carrera> updateCarrera(@PathVariable Integer id, @RequestBody Carrera carreraDetails) {
        Optional<Carrera> carrera = carreraService.updateCarrera(id, carreraDetails);
        return carrera.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCarrera(@PathVariable Integer id) {
        if (carreraService.getCarreraById(id).isPresent()) {
            carreraService.deleteCarrera(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
