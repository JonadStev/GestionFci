package com.istartDigital.procesos.proyectos.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.istartDigital.coreBussines.model.Bloque;
import com.istartDigital.gestion.producto.model.Producto;
import com.istartDigital.procesos.horas.model.AsignacionHoras;
import com.istartDigital.procesos.monitoreo.model.Monitoreo;
import com.istartDigital.security.model.Rol;
import com.istartDigital.security.model.Usuario;

import javax.persistence.*;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "PROYECTOFCI")
public class Proyecto implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String idProyecto;
    private String nombre;
    private String convocatoria;
    private String estado;
    private Date fechaInicio;
    private Date fechaFin;

    @ManyToOne
    @JoinColumn(name = "id_director")
    //@JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private Usuario director;

    @ManyToMany
    @JoinTable(name = "PROYECTO_INVESTIGADOR", joinColumns = @JoinColumn(name = "proyecto_id"),
            inverseJoinColumns = @JoinColumn(name = "investigador_id"))
    //@JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private Set<Usuario> investigadores = new HashSet<>();
    private String correoDirector;
    private String telefonoDirector;

    @OneToOne(mappedBy = "proyecto")
    private Producto producto;

    @OneToOne(mappedBy = "proyecto")
    private Monitoreo monitoreo;

    @OneToOne(mappedBy = "proyecto")
    private AsignacionHoras horas;

    public Proyecto() {
    }

    public Proyecto(String idProyecto, String nombre, String convocatoria, String estado, Date fechaInicio, Date fechaFin, Usuario director, String correoDirector, String telefonoDirector) {
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
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String strDate = dateFormat.format(fechaInicio);
        return strDate;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String strDate = dateFormat.format(fechaFin);
        return strDate;
    }

    public void setFechaFin(Date fechaFin) {
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

    public String getNombrecompletoDirector (){return this.director.getNombre() + ' '+this.director.getApellido();}

}
