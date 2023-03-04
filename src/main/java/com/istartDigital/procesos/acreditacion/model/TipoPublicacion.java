package com.istartDigital.procesos.acreditacion.model;

import javax.persistence.*;

@Entity
@Table(name = "TIPO_PUBLICACION")
public class TipoPublicacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;
    private String estado;

    public TipoPublicacion() {
    }

    public TipoPublicacion(String nombre, String estado) {
        this.nombre = nombre;
        this.estado = estado;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
}

