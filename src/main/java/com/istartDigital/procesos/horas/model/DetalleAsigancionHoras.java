package com.istartDigital.procesos.horas.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.istartDigital.procesos.proyectos.model.Proyecto;
import com.istartDigital.security.model.Usuario;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "DETALLE_ASIGNACION_HORAS")
public class DetalleAsigancionHoras {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String reqHoras;
    private int horasTotalInvestigacionAsignada;
    private int horasInvestigacionAsignadaProyecto;
    private int horasInvestigacionAsignadaTitulacion;
    private int numeroTrabajoTitulacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="horas_id", nullable=false)
    private AsignacionHoras horas;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_investigador")
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private Usuario investigador;


    public DetalleAsigancionHoras() {
    }

    public DetalleAsigancionHoras(String reqHoras, int horasTotalInvestigacionAsignada, int horasInvestigacionAsignadaProyecto, int horasInvestigacionAsignadaTitulacion, int numeroTrabajoTitulacion, Usuario investigador) {
        this.reqHoras = reqHoras;
        this.horasTotalInvestigacionAsignada = horasTotalInvestigacionAsignada;
        this.horasInvestigacionAsignadaProyecto = horasInvestigacionAsignadaProyecto;
        this.horasInvestigacionAsignadaTitulacion = horasInvestigacionAsignadaTitulacion;
        this.numeroTrabajoTitulacion = numeroTrabajoTitulacion;
        this.investigador = investigador;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getReqHoras() {
        return reqHoras;
    }

    public void setReqHoras(String reqHoras) {
        this.reqHoras = reqHoras;
    }

    public int getHorasTotalInvestigacionAsignada() {
        return horasTotalInvestigacionAsignada;
    }

    public void setHorasTotalInvestigacionAsignada(int horasTotalInvestigacionAsignada) {
        this.horasTotalInvestigacionAsignada = horasTotalInvestigacionAsignada;
    }

    public int getHorasInvestigacionAsignadaProyecto() {
        return horasInvestigacionAsignadaProyecto;
    }

    public void setHorasInvestigacionAsignadaProyecto(int horasInvestigacionAsignadaProyecto) {
        this.horasInvestigacionAsignadaProyecto = horasInvestigacionAsignadaProyecto;
    }

    public int getHorasInvestigacionAsignadaTitulacion() {
        return horasInvestigacionAsignadaTitulacion;
    }

    public void setHorasInvestigacionAsignadaTitulacion(int horasInvestigacionAsignadaTitulacion) {
        this.horasInvestigacionAsignadaTitulacion = horasInvestigacionAsignadaTitulacion;
    }

    public int getNumeroTrabajoTitulacion() {
        return numeroTrabajoTitulacion;
    }

    public void setNumeroTrabajoTitulacion(int numeroTrabajoTitulacion) {
        this.numeroTrabajoTitulacion = numeroTrabajoTitulacion;
    }

    public void setHoras(AsignacionHoras horas) {
        this.horas = horas;
    }

    public Usuario getInvestigador() {
        return investigador;
    }

    public void setInvestigador(Usuario investigador) {
        this.investigador = investigador;
    }
}
