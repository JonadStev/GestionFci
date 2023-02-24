package com.istartDigital.gestion.producto.model;

import com.istartDigital.gestion.producto.model.Producto;

import javax.persistence.*;

@Entity
@Table(name = "PROPIEDAD_INTELECTUAL")
public class PropiedadIntelectual {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String industrial;
    private String autor;
    private String vegetal;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "piPropuesto")
    private Producto productoPropuesto;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "piCumplido")
    private Producto productoCumplido;

    public PropiedadIntelectual() {
    }

    public PropiedadIntelectual(String industrial, String autor, String vegetal) {
        this.industrial = industrial;
        this.autor = autor;
        this.vegetal = vegetal;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIndustrial() {
        return industrial;
    }

    public void setIndustrial(String industrial) {
        this.industrial = industrial;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getVegetal() {
        return vegetal;
    }

    public void setVegetal(String vegetal) {
        this.vegetal = vegetal;
    }
}
