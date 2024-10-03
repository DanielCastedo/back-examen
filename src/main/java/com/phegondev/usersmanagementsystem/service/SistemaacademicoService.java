package com.phegondev.usersmanagementsystem.service;

import com.phegondev.usersmanagementsystem.entity.Sistemaacademico;
import com.phegondev.usersmanagementsystem.repository.SistemaacademicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SistemaacademicoService {

    @Autowired
    private SistemaacademicoRepository sistemaacademicoRepository;

    public List<Sistemaacademico> getAllSistemasacademicos() {
        return sistemaacademicoRepository.findAll();
    }

    public Optional<Sistemaacademico> getSistemaacademicoById(Integer id) {
        return sistemaacademicoRepository.findById(id);
    }

    public Sistemaacademico createSistemaacademico(Sistemaacademico sistemaacademico) {
        return sistemaacademicoRepository.save(sistemaacademico);
    }

    public Optional<Sistemaacademico> updateSistemaacademico(Integer id, Sistemaacademico sistemaacademicoDetails) {
        return sistemaacademicoRepository.findById(id).map(sistemaacademico -> {
            sistemaacademico.setNombre(sistemaacademicoDetails.getNombre());
            return sistemaacademicoRepository.save(sistemaacademico);
        });
    }

    public void deleteSistemaacademico(Integer id) {
        sistemaacademicoRepository.deleteById(id);
    }
}
