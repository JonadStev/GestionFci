package com.istartDigital.coreBussines.model;

import javax.persistence.*;

@Entity
@Table(name = "tbl_mantenimiento")
public class Mantenimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long bloque;
    private String fechaInicio;
    private String fechaFin;
    private String descripcion;
    private String tiempo;
    private String responsable;

    public Mantenimiento() {
    }

    public Mantenimiento(long bloque, String fechaInicio, String fechaFin, String descripcion, String tiempo, String responsable) {
        this.bloque = bloque;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.descripcion = descripcion;
        this.tiempo = tiempo;
        this.responsable = responsable;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getBloque() {
        return bloque;
    }

    public void setBloque(long bloque) {
        this.bloque = bloque;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }
}
