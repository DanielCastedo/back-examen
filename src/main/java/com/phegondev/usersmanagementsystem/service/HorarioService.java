package com.phegondev.usersmanagementsystem.service;

import com.phegondev.usersmanagementsystem.entity.Aula;
import com.phegondev.usersmanagementsystem.entity.Grupo;
import com.phegondev.usersmanagementsystem.entity.Horario;
import com.phegondev.usersmanagementsystem.repository.AulaRepository;
import com.phegondev.usersmanagementsystem.repository.GrupoRepository;
import com.phegondev.usersmanagementsystem.repository.HorarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HorarioService {

    @Autowired
    private HorarioRepository horarioRepository;

    @Autowired
    private GrupoRepository grupoRepository;

    @Autowired
    private AulaRepository aulaRepository;


    public List<Horario> getAllHorarios() {
        return horarioRepository.findAll();
    }

    public Optional<Horario> getHorarioById(Integer id) {
        return horarioRepository.findById(id);
    }

    public Horario createHorario(Horario horario) {
        if (horario.getGrupo() != null && horario.getGrupo().getId() != null) {
            Optional<Grupo> grupoOptional = grupoRepository.findById(horario.getGrupo().getId());
            grupoOptional.ifPresent(horario::setGrupo);
        }

        if (horario.getAula() != null && horario.getAula().getId() != null) {
            Optional<Aula> aulaOptional = aulaRepository.findById(horario.getAula().getId());
            aulaOptional.ifPresent(horario::setAula);
        }
        return horarioRepository.save(horario);
    }

    public Optional<Horario> updateHorario(Integer id, Horario horarioDetails) {
        Optional<Horario> horario = horarioRepository.findById(id);
        if (horario.isPresent()) {
            Horario horarioToUpdate = horario.get();
            horarioToUpdate.setDia(horarioDetails.getDia());
            horarioToUpdate.setHorainicio(horarioDetails.getHorainicio());
            horarioToUpdate.setHorafin(horarioDetails.getHorafin());
            // Verificar y actualizar el aula asociada
            if (horarioDetails.getGrupo() != null && horarioDetails.getGrupo().getId() != null) {
                Optional<Grupo> grupoOptional = grupoRepository.findById(horarioDetails.getGrupo().getId());
                grupoOptional.ifPresent(horarioToUpdate::setGrupo);
            }
            // Verificar y actualizar el aula asociada
            if (horarioDetails.getAula() != null && horarioDetails.getAula().getId() != null) {
                Optional<Aula> aulaOptional = aulaRepository.findById(horarioDetails.getAula().getId());
                aulaOptional.ifPresent(horarioToUpdate::setAula);
            }
            return Optional.of(horarioRepository.save(horarioToUpdate));
        } else {
            return Optional.empty();
        }
    }

    public void deleteHorario(Integer id) {
        horarioRepository.deleteById(id);
    }
}
