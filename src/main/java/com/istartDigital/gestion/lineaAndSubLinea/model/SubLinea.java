package com.istartDigital.gestion.lineaAndSubLinea.model;

import javax.persistence.*;

@Entity
@Table(name = "SUBLINEA")
public class SubLinea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String estado;
    private int linea;

    public SubLinea() {
    }

    public SubLinea(String nombre, String estado, int linea) {
        this.nombre = nombre;
        this.estado = estado;
        this.linea = linea;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getLinea() {
        return linea;
    }

    public void setLinea(int linea) {
        this.linea = linea;
    }
}
