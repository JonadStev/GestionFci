package com.istartDigital.gestion.producto.model;

import com.istartDigital.gestion.producto.model.Producto;

import javax.persistence.*;

@Entity
@Table(name = "PRODUCCION_CIENTIFICA")
public class ProduccionCientifica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String regional;
    private String libros;
    private String mundial;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "pcPropuesto")
    private Producto productoPropuesto;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "pcCumplido")
    private Producto productoCumplido;

    public ProduccionCientifica() {
    }

    public ProduccionCientifica(String regional, String libros, String mundial) {
        this.regional = regional;
        this.libros = libros;
        this.mundial = mundial;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRegional() {
        return regional;
    }

    public void setRegional(String regional) {
        this.regional = regional;
    }

    public String getLibros() {
        return libros;
    }

    public void setLibros(String libros) {
        this.libros = libros;
    }

    public String getMundial() {
        return mundial;
    }

    public void setMundial(String mundial) {
        this.mundial = mundial;
    }
}
