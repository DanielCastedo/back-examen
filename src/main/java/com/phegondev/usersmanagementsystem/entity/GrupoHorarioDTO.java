package com.phegondev.usersmanagementsystem.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Time;
import java.util.List;

public class GrupoHorarioDTO {
    private Integer id;
    private String nombre;
    private Integer cupo;
    private String carreraNombre;
    private String gestionNombre;
    private String materiaNombre;
    private String ourUsersNombre;
    private String sistemaacademicoNombre;
    private List<HorarioInfo> horarios;

    // Getters y Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCupo() {
        return cupo;
    }

    public void setCupo(Integer cupo) {
        this.cupo = cupo;
    }

    public String getCarreraNombre() {
        return carreraNombre;
    }

    public void setCarreraNombre(String carreraNombre) {
        this.carreraNombre = carreraNombre;
    }

    public String getGestionNombre() {
        return gestionNombre;
    }

    public void setGestionNombre(String gestionNombre) {
        this.gestionNombre = gestionNombre;
    }

    public String getMateriaNombre() {
        return materiaNombre;
    }

    public void setMateriaNombre(String materiaNombre) {
        this.materiaNombre = materiaNombre;
    }

    public String getOurUsersNombre() {
        return ourUsersNombre;
    }

    public void setOurUsersNombre(String ourUsersNombre) {
        this.ourUsersNombre = ourUsersNombre;
    }

    public String getSistemaacademicoNombre() {
        return sistemaacademicoNombre;
    }

    public void setSistemaacademicoNombre(String sistemaacademicoNombre) {
        this.sistemaacademicoNombre = sistemaacademicoNombre;
    }

    public List<HorarioInfo> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<HorarioInfo> horarios) {
        this.horarios = horarios;
    }

    public static class HorarioInfo {
        private String dia;
        private Time horainicio;
        private Time horafin;
        private String aulaNombre;
        private Double moduloLatitud;
        private Double moduloLongitud;

        // Getters y Setters

        public String getDia() {
            return dia;
        }

        public void setDia(String dia) {
            this.dia = dia;
        }

        public Time getHorainicio() {
            return horainicio;
        }

        public void setHorainicio(Time horainicio) {
            this.horainicio = horainicio;
        }

        public Time getHorafin() {
            return horafin;
        }

        public void setHorafin(Time horafin) {
            this.horafin = horafin;
        }

        public String getAulaNombre() {
            return aulaNombre;
        }

        public void setAulaNombre(String aulaNombre) {
            this.aulaNombre = aulaNombre;
        }

        public Double getModuloLatitud() {
            return moduloLatitud;
        }

        public void setModuloLatitud(Double moduloLatitud) {
            this.moduloLatitud = moduloLatitud;
        }

        public Double getModuloLongitud() {
            return moduloLongitud;
        }

        public void setModuloLongitud(Double moduloLongitud) {
            this.moduloLongitud = moduloLongitud;
        }
    }
}


//public class GrupoHorarioDTO {
//    private Integer id;
//    private String nombre;
//    private Integer cupo;
//    private String carreraNombre;
//    private String gestionNombre;
//    private String materiaNombre;
//    private String ourUsersNombre;
//    private String sistemaacademicoNombre;
//    private List<HorarioInfo> horarios;
//
//    // Getters y Setters
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getNombre() {
//        return nombre;
//    }
//
//    public void setNombre(String nombre) {
//        this.nombre = nombre;
//    }
//
//    public Integer getCupo() {
//        return cupo;
//    }
//
//    public void setCupo(Integer cupo) {
//        this.cupo = cupo;
//    }
//
//    public String getCarreraNombre() {
//        return carreraNombre;
//    }
//
//    public void setCarreraNombre(String carreraNombre) {
//        this.carreraNombre = carreraNombre;
//    }
//
//    public String getGestionNombre() {
//        return gestionNombre;
//    }
//
//    public void setGestionNombre(String gestionNombre) {
//        this.gestionNombre = gestionNombre;
//    }
//
//    public String getMateriaNombre() {
//        return materiaNombre;
//    }
//
//    public void setMateriaNombre(String materiaNombre) {
//        this.materiaNombre = materiaNombre;
//    }
//
//    public String getOurUsersNombre() {
//        return ourUsersNombre;
//    }
//
//    public void setOurUsersNombre(String ourUsersNombre) {
//        this.ourUsersNombre = ourUsersNombre;
//    }
//
//    public String getSistemaacademicoNombre() {
//        return sistemaacademicoNombre;
//    }
//
//    public void setSistemaacademicoNombre(String sistemaacademicoNombre) {
//        this.sistemaacademicoNombre = sistemaacademicoNombre;
//    }
//
//    public List<HorarioInfo> getHorarios() {
//        return horarios;
//    }
//
//    public void setHorarios(List<HorarioInfo> horarios) {
//        this.horarios = horarios;
//    }
//
//    public static class HorarioInfo {
//        private String dia;
//        private Time horainicio;
//        private Time horafin;
//
//        // Getters y Setters
//
//        public String getDia() {
//            return dia;
//        }
//
//        public void setDia(String dia) {
//            this.dia = dia;
//        }
//
//        public Time getHorainicio() {
//            return horainicio;
//        }
//
//        public void setHorainicio(Time horainicio) {
//            this.horainicio = horainicio;
//        }
//
//        public Time getHorafin() {
//            return horafin;
//        }
//
//        public void setHorafin(Time horafin) {
//            this.horafin = horafin;
//        }
//    }
//}