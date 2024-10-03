package com.phegondev.usersmanagementsystem.service;

import com.phegondev.usersmanagementsystem.entity.Facultad;
import com.phegondev.usersmanagementsystem.repository.FacultadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacultadService {

    @Autowired
    private FacultadRepository facultadRepository;

    public List<Facultad> findAll() {
        return facultadRepository.findAll();
    }

    public Optional<Facultad> findById(Integer id) {
        return facultadRepository.findById(id);
    }

    public Facultad save(Facultad facultad) {
        return facultadRepository.save(facultad);
    }

    public void deleteById(Integer id) {
        facultadRepository.deleteById(id);
    }
}
