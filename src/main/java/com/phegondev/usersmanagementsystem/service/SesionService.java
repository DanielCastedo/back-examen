package com.phegondev.usersmanagementsystem.service;

import com.phegondev.usersmanagementsystem.entity.OurUsers;
import com.phegondev.usersmanagementsystem.entity.Sesion;
import com.phegondev.usersmanagementsystem.repository.Sesionrepo;
import com.phegondev.usersmanagementsystem.repository.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SesionService {

    @Autowired
    private Sesionrepo sesionrepo;

    @Autowired
    private UsersRepo usersRepo;

    // Crear una nueva sesión
    public Sesion createSesion(String link, String nombre, Integer userId) {
        Optional<OurUsers> user = usersRepo.findById(userId);
        if (user.isPresent()) {
            Sesion sesion = new Sesion();
            sesion.setLink(link);
            sesion.setNombre(nombre);
            sesion.setOurUser(user.get());
            return sesionrepo.save(sesion);
        } else {
            throw new IllegalArgumentException("User not found");
        }
    }

    // Obtener todas las sesiones
    public List<Sesion> getAllSesiones() {
        return sesionrepo.findAll();
    }

    // Obtener sesiones por ID de usuario
    public List<Sesion> getSesionesByUserId(Integer userId) {
        return sesionrepo.findAll()
                .stream()
                .filter(sesion -> sesion.getOurUser().getId().equals(userId))
                .toList();
    }

    // Eliminar una sesión por su ID
    public void deleteSesion(Integer sesionId) {
        if (sesionrepo.existsById(sesionId)) {
            sesionrepo.deleteById(sesionId);
        } else {
            throw new IllegalArgumentException("Sesion not found");
        }
    }
}
