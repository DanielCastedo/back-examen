package com.phegondev.usersmanagementsystem.service;
import com.phegondev.usersmanagementsystem.entity.Docente;
import com.phegondev.usersmanagementsystem.entity.Materia;
import com.phegondev.usersmanagementsystem.entity.OurUsers;
import com.phegondev.usersmanagementsystem.repository.DocenteRepository;
import com.phegondev.usersmanagementsystem.repository.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocenteService {

    @Autowired
    private DocenteRepository docenteRepository;

    @Autowired
    private UsersRepo usersRepo;

    public List<Docente> getAllDocentes() {
        return docenteRepository.findAll();
    }

    public Docente saveDocente(Docente docente, String userEmail) {
        OurUsers ourUser = usersRepo.findByEmail(userEmail)
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));
        docente.setOurUser(ourUser);
        return docenteRepository.save(docente);
    }

    public Docente updateDocente(Integer id, Docente updatedDocente) {
        Docente existingDocente = docenteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Docente no encontrado"));

        existingDocente.setCodigo(updatedDocente.getCodigo());
        existingDocente.setCi(updatedDocente.getCi());
        existingDocente.setNombre(updatedDocente.getNombre());
        existingDocente.setSexo(updatedDocente.getSexo());

        return docenteRepository.save(existingDocente);
    }

    public void deleteDocente(Integer id) {
        docenteRepository.deleteById(id);
    }

    public Docente getDocenteById(Integer id) {
        return docenteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Docente no encontrado"));
    }
}