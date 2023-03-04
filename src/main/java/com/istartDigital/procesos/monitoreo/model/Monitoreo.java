package com.istartDigital.procesos.monitoreo.model;

import com.istartDigital.procesos.proyectos.model.Proyecto;

import javax.persistence.*;

@Entity
@Table(name = "MONITOREO")
public class Monitoreo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne
    @JoinColumn(name = "id_proyecto")
    private Proyecto proyecto;
    private String autoevaluacion;
    private String informe;

    public Monitoreo() {
    }

    public Monitoreo(Proyecto proyecto, String autoevaluacion, String informe) {
        this.proyecto = proyecto;
        this.autoevaluacion = autoevaluacion;
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
