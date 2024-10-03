package com.phegondev.usersmanagementsystem.controller;

import com.phegondev.usersmanagementsystem.entity.Grupo;
import com.phegondev.usersmanagementsystem.repository.AsistenciaRepository;
import com.phegondev.usersmanagementsystem.service.GrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import com.phegondev.usersmanagementsystem.entity.GrupoHorarioDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/grupos")
public class GrupoController {

    @Autowired
    private GrupoService grupoService;
    private AsistenciaRepository asistenciaRepository;

    @GetMapping
    public List<Grupo> getAllGrupos() {
        return grupoService.getAllGrupos();
    }

    @GetMapping("/ourUsers/{ourUsersId}")
    public List<Grupo> getGruposByOurUsersId(@PathVariable Integer ourUsersId) {
        return grupoService.getGruposByOurUsersId(ourUsersId);
    }

    @GetMapping("/ourUsers/{ourUsersId}/horarios")
    public ResponseEntity<List<GrupoHorarioDTO>> getGrupoHorariosByOurUsersId(@PathVariable Integer ourUsersId) {
        List<GrupoHorarioDTO> grupoHorariosDTOList = grupoService.getGrupoHorariosByOurUsersId(ourUsersId);
        if (grupoHorariosDTOList.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(grupoHorariosDTOList);
    }

//    @GetMapping("/ourUsers/{ourUsersId}")
//    public List<Grupo> getGruposByOurUsersId(@PathVariable Integer ourUsersId) {
//        return grupoService.getGruposByOurUsersId(ourUsersId);
//    }
    @GetMapping("/{id}")
    public ResponseEntity<Grupo> getGrupoById(@PathVariable Integer id) {
        Optional<Grupo> grupo = grupoService.getGrupoById(id);
        return grupo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PostMapping
    public Grupo createGrupo(@RequestBody Grupo grupo) {
        return grupoService.createGrupo(grupo);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Grupo> updateGrupo(@PathVariable Integer id, @RequestBody Grupo grupoDetails) {
        Optional<Grupo> updatedGrupo = grupoService.updateGrupo(id, grupoDetails);
        return updatedGrupo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGrupo(@PathVariable Integer id) {
        if (grupoService.getGrupoById(id).isPresent()) {
            grupoService.deleteGrupo(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

