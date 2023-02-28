package com.istartDigital.gestion.producto.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.istartDigital.procesos.proyectos.model.*;
import com.istartDigital.security.model.Usuario;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "PRODUCTO")
public class Producto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne()
    @JoinColumn(name = "id_proyecto")
    //@JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private Proyecto proyecto;

    private String nombreProyecto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_director")
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private Usuario director;

    private String estado;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_pc_propuesto")
    //@JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private ProduccionCientifica pcPropuesto;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_pc_cumplido")
    //@JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private ProduccionCientifica pcCumplido;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_pi_propuesto")
    //@JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private PropiedadIntelectual piPropuesto;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_pi_cumplido")
    //@JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private PropiedadIntelectual piCumplido;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_conocimiento_propuesto")
    //@JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private Conocimiento conocimientoPropuesto;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_conocimiento_cumplido")
    //@JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private Conocimiento conocimientoCumplido;

    @OneToOne( cascade = CascadeType.ALL)
    @JoinColumn(name = "id_piramide_propuesto")
    //@JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private PiramideCientifica piramidePropuesto;

    @OneToOne( cascade = CascadeType.ALL)
    @JoinColumn(name = "id_piramide_cumplido")
    //@JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private PiramideCientifica piramideCumplido;

    public Producto() {
    }

    public Producto(Proyecto proyecto, String nombreProyecto, Usuario director, String estado, ProduccionCientifica pcPropuesto, ProduccionCientifica pcCumplido , PropiedadIntelectual piPropuesto, PropiedadIntelectual piCumplido, Conocimiento conocimientoPropuesto, Conocimiento conocimientoCumplido, PiramideCientifica piramidePropuesto, PiramideCientifica piramideCumplido) {
        this.proyecto = proyecto;
        this.nombreProyecto = nombreProyecto;
        this.director = director;
        this.estado = estado;
        this.pcPropuesto = pcPropuesto;
        this.pcCumplido = pcCumplido;
        this.piPropuesto = piPropuesto;
        this.piCumplido = piCumplido;
        this.conocimientoPropuesto = conocimientoPropuesto;
        this.conocimientoCumplido = conocimientoCumplido;
        this.piramidePropuesto = piramidePropuesto;
        this.piramideCumplido = piramideCumplido;
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

    public Usuario getDirector() {
        return director;
    }

    public void setDirector(Usuario director) {
        this.director = director;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }


    public ProduccionCientifica getPcPropuesto() {
        return pcPropuesto;
    }

    public void setPcPropuesto(ProduccionCientifica pcPropuesto) {
        this.pcPropuesto = pcPropuesto;
    }

    public ProduccionCientifica getPcCumplido() {
        return pcCumplido;
    }

    public void setPcCumplido(ProduccionCientifica pcCumplido) {
        this.pcCumplido = pcCumplido;
    }

    public PropiedadIntelectual getPiPropuesto() {
        return piPropuesto;
    }

    public void setPiPropuesto(PropiedadIntelectual piPropuesto) {
        this.piPropuesto = piPropuesto;
    }

    public PropiedadIntelectual getPiCumplido() {
        return piCumplido;
    }

    public void setPiCumplido(PropiedadIntelectual piCumplido) {
        this.piCumplido = piCumplido;
    }

    public Conocimiento getConocimientoPropuesto() {
        return conocimientoPropuesto;
    }

    public void setConocimientoPropuesto(Conocimiento conocimientoPropuesto) {
        this.conocimientoPropuesto = conocimientoPropuesto;
    }

    public Conocimiento getConocimientoCumplido() {
        return conocimientoCumplido;
    }

    public void setConocimientoCumplido(Conocimiento conocimientoCumplido) {
        this.conocimientoCumplido = conocimientoCumplido;
    }

    public PiramideCientifica getPiramidePropuesto() {
        return piramidePropuesto;
    }

    public void setPiramidePropuesto(PiramideCientifica piramidePropuesto) {
        this.piramidePropuesto = piramidePropuesto;
    }

    public PiramideCientifica getPiramideCumplido() {
        return piramideCumplido;
    }

    public void setPiramideCumplido(PiramideCientifica piramideCumplido) {
        this.piramideCumplido = piramideCumplido;
    }
}
