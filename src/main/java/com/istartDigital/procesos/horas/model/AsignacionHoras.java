package com.istartDigital.procesos.horas.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.istartDigital.gestion.producto.model.Producto;
import com.istartDigital.procesos.proyectos.model.Proyecto;
import com.istartDigital.security.model.Usuario;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "ASIGNACION_HORAS")
public class AsignacionHoras implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_proyecto")
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private Proyecto proyecto;
    private String nombreProyecto;
    private String convocatoria;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_director")
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private Usuario director;
    private String informe;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "horas", cascade = CascadeType.ALL)
    private List<DetalleAsigancionHoras> detalle;

    public AsignacionHoras() {
    }

    public AsignacionHoras(Proyecto proyecto, String nombreProyecto, String convocatoria, Usuario director, String informe) {
        this.proyecto = proyecto;
        this.nombreProyecto = nombreProyecto;
        this.convocatoria = convocatoria;
        this.director = director;
        this.informe = informe;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public String getConvocatoria() {
        return convocatoria;
    }

    public void setConvocatoria(String convocatoria) {
        this.convocatoria = convocatoria;
    }

    public Usuario getDirector() {
        return director;
    }

    public void setDirector(Usuario director) {
        this.director = director;
    }

    public String getInforme() {
        return informe;
    }

    public void setInforme(String informe) {
        this.informe = informe;
    }

    public List<DetalleAsigancionHoras> getDetalle() {
        return detalle;
    }

    public void setDetalle(List<DetalleAsigancionHoras> detalle) {
        this.detalle = detalle;
    }
}
