package com.phegondev.usersmanagementsystem.service;

import com.phegondev.usersmanagementsystem.entity.Grupo;
import com.phegondev.usersmanagementsystem.entity.Licencia;
import com.phegondev.usersmanagementsystem.entity.OurUsers;
import com.phegondev.usersmanagementsystem.repository.GrupoRepository;
import com.phegondev.usersmanagementsystem.repository.LicenciaRepository;
import com.phegondev.usersmanagementsystem.repository.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LicenciaService {

    @Autowired
    private LicenciaRepository licenciaRepository;

    @Autowired
    private GrupoRepository grupoRepository;

    @Autowired
    private UsersRepo usersRepo;

    public List<Licencia> getAllLicencias() {
        return licenciaRepository.findAll();
    }

    public Optional<Licencia> getLicenciaById(Integer id) {
        return licenciaRepository.findById(id);
    }

    public Licencia createLicencia(Licencia licencia) {
        if (licencia.getGrupo() != null && licencia.getGrupo().getId() != null) {
            Optional<Grupo> grupoOptional = grupoRepository.findById(licencia.getGrupo().getId());
            grupoOptional.ifPresent(licencia::setGrupo);
        }

        if (licencia.getOurUsers() != null && licencia.getOurUsers().getId() != null) {
            Optional<OurUsers> userOptional = usersRepo.findById(licencia.getOurUsers().getId());
            userOptional.ifPresent(licencia::setOurUsers);
        }

        return licenciaRepository.save(licencia);
    }

    public Optional<Licencia> updateLicencia(Integer id, Licencia licenciaDetails) {
        Optional<Licencia> licencia = licenciaRepository.findById(id);
        if (licencia.isPresent()) {
            Licencia licenciaToUpdate = licencia.get();
            licenciaToUpdate.setDescripcion(licenciaDetails.getDescripcion());
            licenciaToUpdate.setHora(licenciaDetails.getHora());
            licenciaToUpdate.setFecha(licenciaDetails.getFecha());

            if (licenciaDetails.getGrupo() != null && licenciaDetails.getGrupo().getId() != null) {
                Optional<Grupo> grupoOptional = grupoRepository.findById(licenciaDetails.getGrupo().getId());
                grupoOptional.ifPresent(licenciaToUpdate::setGrupo);
            }

            if (licenciaDetails.getOurUsers() != null && licenciaDetails.getOurUsers().getId() != null) {
                Optional<OurUsers> userOptional = usersRepo.findById(licenciaDetails.getOurUsers().getId());
                userOptional.ifPresent(licenciaToUpdate::setOurUsers);
            }

            return Optional.of(licenciaRepository.save(licenciaToUpdate));
        } else {
            return Optional.empty();
        }
    }

    public void deleteLicencia(Integer id) {
        licenciaRepository.deleteById(id);
    }
}
