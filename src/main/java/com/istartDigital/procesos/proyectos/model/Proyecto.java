package com.istartDigital.procesos.proyectos.model;

import com.istartDigital.security.model.Rol;
import com.istartDigital.security.model.Usuario;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "PROYECTOFCI")
public class Proyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String idProyecto;
    private String nombre;
    private String convocatoria;
    private String estado;
    private Date fechaInicio;
    private Date fechaFin;
    private String director;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(name = "PROYECTO_INVESTIGADOR", joinColumns = @JoinColumn(name = "proyecto_id"),
            inverseJoinColumns = @JoinColumn(name = "investigador_id"))
    private Set<Usuario> investigadores = new HashSet<>();
    private String correoDirector;
    private String telefonoDirector;
    private String autoevaluacion;
    private String informe;

    public Proyecto() {
    }

    public Proyecto(String idProyecto, String nombre, String convocatoria, String estado, Date fechaInicio, Date fechaFin, String director, String correoDirector, String telefonoDirector, String autoevaluacion, String informe) {
        this.idProyecto = idProyecto;
        this.nombre = nombre;
        this.convocatoria = convocatoria;
        this.estado = estado;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.director = director;
        this.correoDirector = correoDirector;
        this.telefonoDirector = telefonoDirector;
        this.autoevaluacion = autoevaluacion;
        this.informe = informe;
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

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
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

    public String getAutoevaluacion() {
        return autoevaluacion;
    }

    public void setAutoevaluacion(String autoevaluacion) {
        this.autoevaluacion = autoevaluacion;
    }

    public String getInforme() {
        return informe;
    }

    public void setInforme(String informe) {
        this.informe = informe;
    }
}
