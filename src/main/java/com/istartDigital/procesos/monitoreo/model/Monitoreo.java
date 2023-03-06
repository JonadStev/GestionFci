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
    private double presupuestoInicial;
    private double presupuestoFinal;

    public Monitoreo() {
    }

    public Monitoreo(Proyecto proyecto, String autoevaluacion, String informe, double presupuestoInicial, double presupuestoFinal) {
        this.proyecto = proyecto;
        this.autoevaluacion = autoevaluacion;
        this.informe = informe;
        this.presupuestoInicial = presupuestoInicial;
        this.presupuestoFinal = presupuestoFinal;
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

    public double getPresupuestoInicial() {
        return presupuestoInicial;
    }

    public void setPresupuestoInicial(double presupuestoInicial) {
        this.presupuestoInicial = presupuestoInicial;
    }

    public double getPresupuestoFinal() {
        return presupuestoFinal;
    }

    public void setPresupuestoFinal(double presupuestoFinal) {
        this.presupuestoFinal = presupuestoFinal;
    }
}
