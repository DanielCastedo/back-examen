package com.phegondev.usersmanagementsystem.service;

import com.phegondev.usersmanagementsystem.entity.Asistencia;
import com.phegondev.usersmanagementsystem.entity.Grupo;
import com.phegondev.usersmanagementsystem.repository.AsistenciaRepository;
import com.phegondev.usersmanagementsystem.repository.GrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AsistenciaService {

    @Autowired
    private AsistenciaRepository asistenciaRepository;

    @Autowired
    private GrupoRepository grupoRepository;

    public List<Asistencia> getAllAsistencias() {
        return asistenciaRepository.findAll();
    }

    public Optional<Asistencia> getAsistenciaById(Integer id) {
        return asistenciaRepository.findById(id);
    }

    public Asistencia createAsistencia(Asistencia asistencia) {
        if (asistencia.getGrupo() != null && asistencia.getGrupo().getId() != null) {
            Optional<Grupo> grupoOptional = grupoRepository.findById(asistencia.getGrupo().getId());
            grupoOptional.ifPresent(asistencia::setGrupo);
        }
        return asistenciaRepository.save(asistencia);
    }

    public Optional<Asistencia> updateAsistencia(Integer id, Asistencia asistenciaDetails) {
        Optional<Asistencia> asistencia = asistenciaRepository.findById(id);
        if (asistencia.isPresent()) {
            Asistencia asistenciaToUpdate = asistencia.get();
            asistenciaToUpdate.setDescripcion(asistenciaDetails.getDescripcion());
            asistenciaToUpdate.setHora(asistenciaDetails.getHora());
            asistenciaToUpdate.setFecha(asistenciaDetails.getFecha());
            asistenciaToUpdate.setTiempo(asistenciaDetails.getTiempo());
            asistenciaToUpdate.setEstado(asistenciaDetails.getEstado());
            asistenciaToUpdate.setLatitud(asistenciaDetails.getLatitud());
            asistenciaToUpdate.setLongitud(asistenciaDetails.getLongitud());
            if (asistenciaDetails.getGrupo() != null && asistenciaDetails.getGrupo().getId() != null) {
                Optional<Grupo> grupoOptional = grupoRepository.findById(asistenciaDetails.getGrupo().getId());
                grupoOptional.ifPresent(asistenciaToUpdate::setGrupo);
            }
            return Optional.of(asistenciaRepository.save(asistenciaToUpdate));
        } else {
            return Optional.empty();
        }
    }

    public void deleteAsistencia(Integer id) {
        asistenciaRepository.deleteById(id);
    }
}
