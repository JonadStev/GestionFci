package com.istartDigital.procesos.acreditacion.model;

import com.istartDigital.security.model.Usuario;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "PONENCIA")
public class Ponencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String facultad;
    private String codigoUg;
    private String tipoPublicacion;
    private String codigoPublicacion;
    private String nombrePonencia;
    private String doi;
    private String nombreEvento;
    private String baseDatosIndexada;
    private String codigoIsbnIss;
    private String tipoIndexacion;
    private String edicionEvento;
    private String organizadorEvento;
    private String comiteCientifico;
    private String pais;
    private String ciudad;
    private Date fechaPublicacion;
    private String quartil;
    private String sjrJcr;
    private double campoDetallado;
    private String linkPublicacion;
    private String filiacionUg;
    private String dominio;
    private String linea;
    private String sublinea;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(name = "ponencia_docente",
            joinColumns = @JoinColumn(name = "ponencia_id"),
            inverseJoinColumns = @JoinColumn(name = "docente_id"))
    private List<Usuario> docentes;
    private String tituloProyectoFci;
    private String observacion;

    public Ponencia() {
    }

    public Ponencia(String facultad, String codigoUg, String tipoPublicacion, String codigoPublicacion, String nombrePonencia, String doi, String nombreEvento, String baseDatosIndexada, String codigoIsbnIss, String tipoIndexacion, String edicionEvento, String organizadorEvento, String comiteCientifico, String pais, String ciudad, Date fechaPublicacion, String quartil, String sjrJcr, double campoDetallado, String linkPublicacion, String filiacionUg, String dominio, String linea, String sublinea, List<Usuario> docentes, String tituloProyectoFci, String observacion) {
        this.facultad = facultad;
        this.codigoUg = codigoUg;
        this.tipoPublicacion = tipoPublicacion;
        this.codigoPublicacion = codigoPublicacion;
        this.nombrePonencia = nombrePonencia;
        this.doi = doi;
        this.nombreEvento = nombreEvento;
        this.baseDatosIndexada = baseDatosIndexada;
        this.codigoIsbnIss = codigoIsbnIss;
        this.tipoIndexacion = tipoIndexacion;
        this.edicionEvento = edicionEvento;
        this.organizadorEvento = organizadorEvento;
        this.comiteCientifico = comiteCientifico;
        this.pais = pais;
        this.ciudad = ciudad;
        this.fechaPublicacion = fechaPublicacion;
        this.quartil = quartil;
        this.sjrJcr = sjrJcr;
        this.campoDetallado = campoDetallado;
        this.linkPublicacion = linkPublicacion;
        this.filiacionUg = filiacionUg;
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

    public String getNombrePonencia() {
        return nombrePonencia;
    }

    public void setNombrePonencia(String nombrePonencia) {
        this.nombrePonencia = nombrePonencia;
    }

    public String getDoi() {
        return doi;
    }

    public void setDoi(String doi) {
        this.doi = doi;
    }

    public String getNombreEvento() {
        return nombreEvento;
    }

    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }

    public String getBaseDatosIndexada() {
        return baseDatosIndexada;
    }

    public void setBaseDatosIndexada(String baseDatosIndexada) {
        this.baseDatosIndexada = baseDatosIndexada;
    }

    public String getCodigoIsbnIss() {
        return codigoIsbnIss;
    }

    public void setCodigoIsbnIss(String codigoIsbnIss) {
        this.codigoIsbnIss = codigoIsbnIss;
    }

    public String getTipoIndexacion() {
        return tipoIndexacion;
    }

    public void setTipoIndexacion(String tipoIndexacion) {
        this.tipoIndexacion = tipoIndexacion;
    }

    public String getEdicionEvento() {
        return edicionEvento;
    }

    public void setEdicionEvento(String edicionEvento) {
        this.edicionEvento = edicionEvento;
    }

    public String getOrganizadorEvento() {
        return organizadorEvento;
    }

    public void setOrganizadorEvento(String organizadorEvento) {
        this.organizadorEvento = organizadorEvento;
    }

    public String getComiteCientifico() {
        return comiteCientifico;
    }

    public void setComiteCientifico(String comiteCientifico) {
        this.comiteCientifico = comiteCientifico;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public String getQuartil() {
        return quartil;
    }

    public void setQuartil(String quartil) {
        this.quartil = quartil;
    }

    public String getSjrJcr() {
        return sjrJcr;
    }

    public void setSjrJcr(String sjrJcr) {
        this.sjrJcr = sjrJcr;
    }

    public double getCampoDetallado() {
        return campoDetallado;
    }

    public void setCampoDetallado(double campoDetallado) {
        this.campoDetallado = campoDetallado;
    }

    public String getLinkPublicacion() {
        return linkPublicacion;
    }

    public void setLinkPublicacion(String linkPublicacion) {
        this.linkPublicacion = linkPublicacion;
    }

    public String getFiliacionUg() {
        return filiacionUg;
    }

    public void setFiliacionUg(String filiacionUg) {
        this.filiacionUg = filiacionUg;
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
