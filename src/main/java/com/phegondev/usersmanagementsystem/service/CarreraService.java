package com.phegondev.usersmanagementsystem.service;

import com.phegondev.usersmanagementsystem.entity.Carrera;
import com.phegondev.usersmanagementsystem.entity.Facultad;
import com.phegondev.usersmanagementsystem.repository.CarreraRepository;
import com.phegondev.usersmanagementsystem.repository.FacultadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarreraService {

    @Autowired
    private CarreraRepository carreraRepository;

    @Autowired
    private FacultadRepository facultadRepository;

    public List<Carrera> getAllCarreras() {
        return carreraRepository.findAll();
    }

    public Optional<Carrera> getCarreraById(Integer id) {
        return carreraRepository.findById(id);
    }

    public Carrera createCarrera(Carrera carrera) {
        if (carrera.getFacultad() != null && carrera.getFacultad().getId() != null) {
            Optional<Facultad> facultadOptional = facultadRepository.findById(carrera.getFacultad().getId());
            facultadOptional.ifPresent(carrera::setFacultad);
        }
        return carreraRepository.save(carrera);
    }

    public Optional<Carrera> updateCarrera(Integer id, Carrera carreraDetails) {
        Optional<Carrera> carrera = carreraRepository.findById(id);
        if (carrera.isPresent()) {
            Carrera carreraToUpdate = carrera.get();
            carreraToUpdate.setNro(carreraDetails.getNro());
            carreraToUpdate.setNombre(carreraDetails.getNombre());
            if (carreraDetails.getFacultad() != null && carreraDetails.getFacultad().getId() != null) {
                Optional<Facultad> facultadOptional = facultadRepository.findById(carreraDetails.getFacultad().getId());
                facultadOptional.ifPresent(carreraToUpdate::setFacultad);
            }
            return Optional.of(carreraRepository.save(carreraToUpdate));
        } else {
            return Optional.empty();
        }
    }

    public void deleteCarrera(Integer id) {
        carreraRepository.deleteById(id);
    }
}
