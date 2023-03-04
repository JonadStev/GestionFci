package com.istartDigital.procesos.acreditacion.model;

import com.istartDigital.gestion.estadoProyectosFci.model.Estado;
import com.istartDigital.gestion.unesco.model.Unesco;
import com.istartDigital.security.model.Usuario;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ARTICULO")
public class Articulo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String facultad;
    private String codigoUg;
    private String tipoPublicacion;
    private String codigoPublicacion;
    private String tituloPublicacion;
    private String doi;
    private String baseDatosindexada;
    private String codigoISSN;
    private String tipoIndexacion;
    private String nombreRevista;
    private String numeroRevista;
    private String quartil;
    private String srjJcr;
    private Date fechaPublicacion;
    private double campoDetallado;
    private String estado;
    private String linkPublicacion;
    private String linkRevista;
    private String filiacion;
    private String dominio;
    private String linea;
    private String sublinea;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(name = "articulo_docente",
            joinColumns = @JoinColumn(name = "articulo_id"),
            inverseJoinColumns = @JoinColumn(name = "docente_id"))
    private List<Usuario> docentes;
    private String tituloProyectoFci;
    private String observacion;

    public Articulo() {
    }

    public Articulo(String facultad, String codigoUg, String tipoPublicacion, String codigoPublicacion, String tituloPublicacion, String doi, String baseDatosindexada, String codigoISSN, String tipoIndexacion, String nombreRevista, String numeroRevista, String quartil, String srjJcr, Date fechaPublicacion, double campoDetallado, String estado, String linkPublicacion, String linkRevista, String filiacion, String dominio, String linea, String sublinea, List<Usuario> docentes, String tituloProyectoFci, String observacion) {
        this.facultad = facultad;
        this.codigoUg = codigoUg;
        this.tipoPublicacion = tipoPublicacion;
        this.codigoPublicacion = codigoPublicacion;
        this.tituloPublicacion = tituloPublicacion;
        this.doi = doi;
        this.baseDatosindexada = baseDatosindexada;
        this.codigoISSN = codigoISSN;
        this.tipoIndexacion = tipoIndexacion;
        this.nombreRevista = nombreRevista;
        this.numeroRevista = numeroRevista;
        this.quartil = quartil;
        this.srjJcr = srjJcr;
        this.fechaPublicacion = fechaPublicacion;
        this.campoDetallado = campoDetallado;
        this.estado = estado;
        this.linkPublicacion = linkPublicacion;
        this.linkRevista = linkRevista;
        this.filiacion = filiacion;
        this.dominio = dominio;
        this.linea = linea;
        this.sublinea = sublinea;
        this.docentes = docentes;
        this.tituloProyectoFci = tituloProyectoFci;
        this.observacion = observacion;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    public String getCodigoUg() {
        return codigoUg;
    }

    public void setCodigoUg(String codigoUg) {
        this.codigoUg = codigoUg;
    }

    public String getTituloPublicacion() {
        return tituloPublicacion;
    }

    public void setTituloPublicacion(String tituloPublicacion) {
        this.tituloPublicacion = tituloPublicacion;
    }

    public String getDoi() {
        return doi;
    }

    public void setDoi(String doi) {
        this.doi = doi;
    }

    public String getBaseDatosindexada() {
        return baseDatosindexada;
    }

    public void setBaseDatosindexada(String baseDatosindexada) {
        this.baseDatosindexada = baseDatosindexada;
    }

    public String getCodigoISSN() {
        return codigoISSN;
    }

    public void setCodigoISSN(String codigoISSN) {
        this.codigoISSN = codigoISSN;
    }

    public String getTipoIndexacion() {
        return tipoIndexacion;
    }

    public void setTipoIndexacion(String tipoIndexacion) {
        this.tipoIndexacion = tipoIndexacion;
    }

    public String getNombreRevista() {
        return nombreRevista;
    }

    public void setNombreRevista(String nombreRevista) {
        this.nombreRevista = nombreRevista;
    }

    public String getNumeroRevista() {
        return numeroRevista;
    }

    public void setNumeroRevista(String numeroRevista) {
        this.numeroRevista = numeroRevista;
    }

    public String getQuartil() {
        return quartil;
    }

    public void setQuartil(String quartil) {
        this.quartil = quartil;
    }

    public String getSrjJcr() {
        return srjJcr;
    }

    public void setSrjJcr(String srjJcr) {
        this.srjJcr = srjJcr;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public double getCampoDetallado() {
        return campoDetallado;
    }

    public void setCampoDetallado(double campoDetallado) {
        this.campoDetallado = campoDetallado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getLinkPublicacion() {
        return linkPublicacion;
    }

    public void setLinkPublicacion(String linkPublicacion) {
        this.linkPublicacion = linkPublicacion;
    }

    public String getLinkRevista() {
        return linkRevista;
    }

    public void setLinkRevista(String linkRevista) {
        this.linkRevista = linkRevista;
    }

    public String getFiliacion() {
        return filiacion;
    }

    public void setFiliacion(String filiacion) {
        this.filiacion = filiacion;
    }

    public String getDominio() {
        return dominio;
    }

    public void setDominio(String dominio) {
        this.dominio = dominio;
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public String getSublinea() {
        return sublinea;
    }

    public void setSublinea(String sublinea) {
        this.sublinea = sublinea;
    }

    public List<Usuario> getDocentes() {
        return docentes;
    }

    public void setDocentes(List<Usuario> docentes) {
        this.docentes = docentes;
    }

    public String getTituloProyectoFci() {
        return tituloProyectoFci;
    }

    public void setTituloProyectoFci(String tituloProyectoFci) {
        this.tituloProyectoFci = tituloProyectoFci;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getTipoPublicacion() {
        return tipoPublicacion;
    }

    public void setTipoPublicacion(String tipoPublicacion) {
        this.tipoPublicacion = tipoPublicacion;
    }

    public String getCodigoPublicacion() {
        return codigoPublicacion;
    }

    public void setCodigoPublicacion(String codigoPublicacion) {
        this.codigoPublicacion = codigoPublicacion;
    }
}
