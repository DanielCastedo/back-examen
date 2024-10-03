package com.phegondev.usersmanagementsystem.service;

import com.phegondev.usersmanagementsystem.entity.Modulo;
import com.phegondev.usersmanagementsystem.repository.ModuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModuloService {

    @Autowired
    private ModuloRepository moduloRepository;

    public List<Modulo> getAllModulos() {
        return moduloRepository.findAll();
    }

    public Optional<Modulo> getModuloById(Integer id) {
        return moduloRepository.findById(id);
    }

    public Modulo createModulo(Modulo modulo) {
        return moduloRepository.save(modulo);
    }

    public Optional<Modulo> updateModulo(Integer id, Modulo moduloDetails) {
        return moduloRepository.findById(id).map(modulo -> {
            modulo.setNombre(moduloDetails.getNombre());
            modulo.setNro(moduloDetails.getNro());
            return moduloRepository.save(modulo);
        });
    }

    public void deleteModulo(Integer id) {
        moduloRepository.deleteById(id);
    }
}
