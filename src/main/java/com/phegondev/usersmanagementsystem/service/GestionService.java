package com.phegondev.usersmanagementsystem.service;

import com.phegondev.usersmanagementsystem.entity.Gestion;
import com.phegondev.usersmanagementsystem.repository.GestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GestionService {

    @Autowired
    private GestionRepository gestionRepository;

    public List<Gestion> getAllGestions() {
        return gestionRepository.findAll();
    }

    public Optional<Gestion> getGestionById(Integer id) {
        return gestionRepository.findById(id);
    }

    public Gestion createGestion(Gestion gestion) {
        return gestionRepository.save(gestion);
    }

    public Optional<Gestion> updateGestion(Integer id, Gestion gestionDetails) {
        return gestionRepository.findById(id).map(gestion -> {
            gestion.setNombre(gestionDetails.getNombre());

            return gestionRepository.save(gestion);
        });
    }

    public void deleteGestion(Integer id) {
        gestionRepository.deleteById(id);
    }
}
