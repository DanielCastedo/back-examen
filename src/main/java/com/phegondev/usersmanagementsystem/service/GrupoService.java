package com.phegondev.usersmanagementsystem.service;

import com.phegondev.usersmanagementsystem.entity.*;
import com.phegondev.usersmanagementsystem.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

@Service
public class GrupoService {

    @Autowired
    private GrupoRepository grupoRepository;

    @Autowired
    private CarreraRepository carreraRepository;

    @Autowired
    private GestionRepository gestionRepository;

    @Autowired
    private MateriaRepository materiaRepository;

    @Autowired
    private UsersRepo usersRepo;

    @Autowired
    private SistemaacademicoRepository sistemaacademicoRepository;


    @Autowired
    private HorarioRepository horarioRepository;



    @Autowired
    private AsistenciaRepository asistenciaRepository;

    // Otros métodos...

    public List<Grupo> getGruposByOurUsersId(Integer ourUsersId) {
       return grupoRepository.findByOurUsersId(ourUsersId);
    }



    public List<GrupoHorarioDTO> getGrupoHorariosByOurUsersId(Integer ourUsersId) {
        List<Grupo> grupos = getGruposByOurUsersId(ourUsersId);
        List<GrupoHorarioDTO> grupoHorariosDTOList = new ArrayList<>();

        for (Grupo grupo : grupos) {
            GrupoHorarioDTO grupoHorarioDTO = new GrupoHorarioDTO();
            grupoHorarioDTO.setId(grupo.getId());
            grupoHorarioDTO.setNombre(grupo.getNombre());
            grupoHorarioDTO.setCupo(grupo.getCupo());
            grupoHorarioDTO.setCarreraNombre(grupo.getCarrera().getNombre());
            grupoHorarioDTO.setGestionNombre(grupo.getGestion().getNombre());
            grupoHorarioDTO.setMateriaNombre(grupo.getMateria().getNombre());
            grupoHorarioDTO.setOurUsersNombre(grupo.getOurUsers().getName());
            grupoHorarioDTO.setSistemaacademicoNombre(grupo.getSistemaacademico().getNombre());

            List<Horario> horarios = horarioRepository.findByGrupoId(grupo.getId());
            List<GrupoHorarioDTO.HorarioInfo> horarioInfos = new ArrayList<>();

            for (Horario horario : horarios) {
                GrupoHorarioDTO.HorarioInfo horarioInfo = new GrupoHorarioDTO.HorarioInfo();
                horarioInfo.setDia(horario.getDia());
                horarioInfo.setHorainicio(horario.getHorainicio());
                horarioInfo.setHorafin(horario.getHorafin());
                horarioInfo.setAulaNombre(horario.getAula().getNombre());
                horarioInfo.setModuloLatitud(horario.getAula().getModulo().getLatitud());
                horarioInfo.setModuloLongitud(horario.getAula().getModulo().getLongitud());
                horarioInfos.add(horarioInfo);
            }

            grupoHorarioDTO.setHorarios(horarioInfos);
            grupoHorariosDTOList.add(grupoHorarioDTO);
        }

        return grupoHorariosDTOList;
    }

//    public List<GrupoHorarioDTO> getGrupoHorariosByOurUsersId(Integer ourUsersId) {
//        List<Grupo> grupos = getGruposByOurUsersId(ourUsersId);
//        List<GrupoHorarioDTO> grupoHorariosDTOList = new ArrayList<>();
//
//        for (Grupo grupo : grupos) {
//            GrupoHorarioDTO grupoHorarioDTO = new GrupoHorarioDTO();
//            grupoHorarioDTO.setId(grupo.getId());
//            grupoHorarioDTO.setNombre(grupo.getNombre());
//            grupoHorarioDTO.setCupo(grupo.getCupo());
//            grupoHorarioDTO.setCarreraNombre(grupo.getCarrera().getNombre());
//            grupoHorarioDTO.setGestionNombre(grupo.getGestion().getNombre());
//            grupoHorarioDTO.setMateriaNombre(grupo.getMateria().getNombre());
//            grupoHorarioDTO.setOurUsersNombre(grupo.getOurUsers().getName());
//            grupoHorarioDTO.setSistemaacademicoNombre(grupo.getSistemaacademico().getNombre());
//
//            List<Horario> horarios = horarioRepository.findByGrupoId(grupo.getId());
//            List<GrupoHorarioDTO.HorarioInfo> horarioInfos = new ArrayList<>();
//
//            for (Horario horario : horarios) {
//                GrupoHorarioDTO.HorarioInfo horarioInfo = new GrupoHorarioDTO.HorarioInfo();
//                horarioInfo.setDia(horario.getDia());
//                horarioInfo.setHorainicio(horario.getHorainicio());
//                horarioInfo.setHorafin(horario.getHorafin());
//                horarioInfos.add(horarioInfo);
//            }
//
//            grupoHorarioDTO.setHorarios(horarioInfos);
//            grupoHorariosDTOList.add(grupoHorarioDTO);
//        }
//
//        return grupoHorariosDTOList;
//    }

    public List<Grupo> getAllGrupos() {
        return grupoRepository.findAll();
    }

    public Optional<Grupo> getGrupoById(Integer id) {
        return grupoRepository.findById(id);
    }


//    public List<Grupo> getGruposByOurUsersId(Integer ourUsersId) {
//        return grupoRepository.findByOurUsersId(ourUsersId);
//    }

    public Grupo createGrupo(Grupo grupo) {

        Optional<Carrera> carreraOptional = carreraRepository.findById(grupo.getCarrera().getId());
        carreraOptional.ifPresent(grupo::setCarrera);

        Optional<Gestion> gestionOptional = gestionRepository.findById(grupo.getGestion().getId());
        gestionOptional.ifPresent(grupo::setGestion);

        Optional<Materia> materiaOptional = materiaRepository.findById(grupo.getMateria().getId());
        materiaOptional.ifPresent(grupo::setMateria);

        Optional<OurUsers> ourUsersOptional = usersRepo.findById(grupo.getOurUsers().getId());
        ourUsersOptional.ifPresent(grupo::setOurUsers);


        Optional<Sistemaacademico> sistemaacademicoOptional = sistemaacademicoRepository.findById(grupo.getSistemaacademico().getId());
        sistemaacademicoOptional.ifPresent(grupo::setSistemaacademico);


        return grupoRepository.save(grupo);

    }


    public Optional<Grupo> updateGrupo(Integer id, Grupo grupoDetails) {
        Optional<Grupo> grupo = grupoRepository.findById(id);
        if (grupo.isPresent()) {
            Grupo grupoToUpdate = grupo.get();
            grupoToUpdate.setNombre(grupoDetails.getNombre());
            grupoToUpdate.setCupo(grupoDetails.getCupo());

            if (grupoDetails.getCarrera() != null && grupoDetails.getCarrera().getId() != null) {
                Optional<Carrera> carreraOptional = carreraRepository.findById(grupoDetails.getCarrera().getId());
                carreraOptional.ifPresent(grupoToUpdate::setCarrera);
            }

            if (grupoDetails.getGestion() != null && grupoDetails.getGestion().getId() != null) {
                Optional<Gestion> gestionOptional = gestionRepository.findById(grupoDetails.getGestion().getId());
                gestionOptional.ifPresent(grupoToUpdate::setGestion);
            }

            if (grupoDetails.getMateria() != null && grupoDetails.getMateria().getId() != null) {
                Optional<Materia> materiaOptional = materiaRepository.findById(grupoDetails.getMateria().getId());
                materiaOptional.ifPresent(grupoToUpdate::setMateria);
            }

            if (grupoDetails.getOurUsers() != null && grupoDetails.getOurUsers().getId() != null) {
                Optional<OurUsers> ourUsersOptional = usersRepo.findById(grupoDetails.getOurUsers().getId());
                ourUsersOptional.ifPresent(grupoToUpdate::setOurUsers);
            }

            if (grupoDetails.getSistemaacademico() != null && grupoDetails.getSistemaacademico().getId() != null) {
                Optional<Sistemaacademico> sistemaacademicoOptional = sistemaacademicoRepository.findById(grupoDetails.getSistemaacademico().getId());
                sistemaacademicoOptional.ifPresent(grupoToUpdate::setSistemaacademico);
            }



            return Optional.of(grupoRepository.save(grupoToUpdate));
        } else {
            return Optional.empty();
        }
    }


    public void deleteGrupo(Integer id) {
        grupoRepository.deleteById(id);
    }
}

