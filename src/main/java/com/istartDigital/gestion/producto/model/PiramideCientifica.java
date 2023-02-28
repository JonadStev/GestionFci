package com.istartDigital.gestion.producto.model;

import com.istartDigital.gestion.producto.model.Producto;

import javax.persistence.*;

@Entity
@Table(name = "PIRAMIDE_CIENTIFICA")
public class PiramideCientifica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String grado;
    private String postGrado;
    private String doctorado;

    @OneToOne(mappedBy = "piramidePropuesto")
    private Producto productoPropuesto;

    @OneToOne(mappedBy = "piramideCumplido")
    private Producto productoCumplido;

    public PiramideCientifica() {
    }

    public PiramideCientifica(String grado, String postGrado, String doctorado) {
        this.grado = grado;
        this.postGrado = postGrado;
        this.doctorado = doctorado;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public String getPostGrado() {
        return postGrado;
    }

    public void setPostGrado(String postGrado) {
        this.postGrado = postGrado;
    }

    public String getDoctorado() {
        return doctorado;
    }

    public void setDoctorado(String doctorado) {
        this.doctorado = doctorado;
    }

}
