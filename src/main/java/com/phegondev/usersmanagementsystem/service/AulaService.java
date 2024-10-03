package com.phegondev.usersmanagementsystem.service;

import com.phegondev.usersmanagementsystem.entity.Aula;
import com.phegondev.usersmanagementsystem.entity.Modulo;
import com.phegondev.usersmanagementsystem.repository.AulaRepository;
import com.phegondev.usersmanagementsystem.repository.ModuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AulaService {

    @Autowired
    private AulaRepository aulaRepository;

    @Autowired
    private ModuloRepository moduloRepository;

    public List<Aula> getAllAulas() {
        return aulaRepository.findAll();
    }

    public Optional<Aula> getAulaById(Integer id) {
        return aulaRepository.findById(id);
    }

    public Aula createAula(Aula aula, Integer moduloId) {
        Modulo modulo = moduloRepository.findById(moduloId).orElseThrow(() -> new RuntimeException("Modulo not found"));
        aula.setModulo(modulo);
        return aulaRepository.save(aula);
    }

    public Optional<Aula> updateAula(Integer id, Aula aulaDetails) {
        return aulaRepository.findById(id).map(aula -> {
            aula.setNombre(aulaDetails.getNombre());
            return aulaRepository.save(aula);
        });
    }

    public void deleteAula(Integer id) {
        aulaRepository.deleteById(id);
    }
}
