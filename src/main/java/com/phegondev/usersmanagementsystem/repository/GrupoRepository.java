package com.phegondev.usersmanagementsystem.repository;

import com.phegondev.usersmanagementsystem.entity.Grupo; // Cambio de Materia a Carrera
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface GrupoRepository extends JpaRepository<Grupo, Integer> { // Cambio de Materia a Carrera

    List<Grupo> findByOurUsersId(Integer ourUsersId);
}
