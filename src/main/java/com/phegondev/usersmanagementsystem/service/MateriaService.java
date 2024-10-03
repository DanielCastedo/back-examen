package com.phegondev.usersmanagementsystem.service;

import com.phegondev.usersmanagementsystem.entity.Materia;
import com.phegondev.usersmanagementsystem.repository.MateriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MateriaService {

    @Autowired
    private MateriaRepository materiaRepository;

    public List<Materia> getAllMaterias() {
        return materiaRepository.findAll();
    }

    public Optional<Materia> getMateriaById(Integer id) {
        return materiaRepository.findById(id);
    }

    public Materia createMateria(Materia materia) {
        return materiaRepository.save(materia);
    }

    public Optional<Materia> updateMateria(Integer id, Materia materiaDetails) {
        return materiaRepository.findById(id).map(materia -> {
            materia.setNombre(materiaDetails.getNombre());
            materia.setSigla(materiaDetails.getSigla());
            materia.setSemestre(materiaDetails.getSemestre());
            return materiaRepository.save(materia);
        });
    }

    public void deleteMateria(Integer id) {
        materiaRepository.deleteById(id);
    }
}
