package com.istartDigital.procesos.proyectos.dto;

import com.istartDigital.security.model.Usuario;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class ProyectoDto {

    private long id;
    private String idProyecto;
    private String nombre;
    private String convocatoria;
    private String estado;
    private String fechaInicio;
    private String fechaFin;
    private Usuario director;
    private Set<Usuario> investigadores = new HashSet<>();
    private String correoDirector;
    private String telefonoDirector;

    public ProyectoDto() {
    }

    public ProyectoDto(String idProyecto, String nombre, String convocatoria, String estado, String fechaInicio, String fechaFin, Usuario director, String correoDirector, String telefonoDirector) {
        this.idProyecto = idProyecto;
        this.nombre = nombre;
        this.convocatoria = convocatoria;
        this.estado = estado;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.director = director;
        this.correoDirector = correoDirector;
        this.telefonoDirector = telefonoDirector;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(String idProyecto) {
        this.idProyecto = idProyecto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getConvocatoria() {
        return convocatoria;
    }

    public void setConvocatoria(String convocatoria) {
        this.convocatoria = convocatoria;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Usuario getDirector() {
        return director;
    }

    public void setDirector(Usuario director) {
        this.director = director;
    }

    public Set<Usuario> getInvestigadores() {
        return investigadores;
    }

    public void setInvestigadores(Set<Usuario> investigadores) {
        this.investigadores = investigadores;
    }

    public String getCorreoDirector() {
        return correoDirector;
    }

    public void setCorreoDirector(String correoDirector) {
        this.correoDirector = correoDirector;
    }

    public String getTelefonoDirector() {
        return telefonoDirector;
    }

    public void setTelefonoDirector(String telefonoDirector) {
        this.telefonoDirector = telefonoDirector;
    }

}
