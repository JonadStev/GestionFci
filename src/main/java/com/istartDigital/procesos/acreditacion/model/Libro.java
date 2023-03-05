package com.istartDigital.procesos.acreditacion.model;

import com.istartDigital.security.model.Usuario;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "LIBRO")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String facultad;
    private String codigoUg;
    private String tipoPublicacion;
    private String codigoPublicacion;
    private String tituloLibro;
    private String codigoIsbn;
    private String editorCompilador;
    private String paginas;
    private Date fechaPublicacion;
    private String linkPublicacion;
    private double campoDetallado;
    private String filiacionUg;
    private String revicionPorPares;
    private String dominio;
    private String linea;
    private String sublinea;
    //@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "libro_docente",
            joinColumns = @JoinColumn(name = "libro_id"),
            inverseJoinColumns = @JoinColumn(name = "docente_id"))
    private Set<Usuario> docentes = new HashSet<>();
    private String tituloProyectoFci;
    private String observacion;

    public Libro() {
    }

    public Libro(String facultad, String codigoUg, String tipoPublicacion, String codigoPublicacion, String tituloLibro, String codigoIsbn, String editorCompilador, String paginas, Date fechaPublicacion, String linkPublicacion, double campoDetallado, String filiacionUg, String revicionPorPares, String dominio, String linea, String sublinea, /*List<Usuario> docentes,*/ String tituloProyectoFci, String observacion) {
        this.facultad = facultad;
        this.codigoUg = codigoUg;
        this.tipoPublicacion = tipoPublicacion;
        this.codigoPublicacion = codigoPublicacion;
        this.tituloLibro = tituloLibro;
        this.codigoIsbn = codigoIsbn;
        this.editorCompilador = editorCompilador;
        this.paginas = paginas;
        this.fechaPublicacion = fechaPublicacion;
        this.linkPublicacion = linkPublicacion;
        this.campoDetallado = campoDetallado;
        this.filiacionUg = filiacionUg;
        this.revicionPorPares = revicionPorPares;
        this.dominio = dominio;
        this.linea = linea;
        this.sublinea = sublinea;
        //this.docentes = docentes;
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

    public String getTituloLibro() {
        return tituloLibro;
    }

    public void setTituloLibro(String tituloLibro) {
        this.tituloLibro = tituloLibro;
    }

    public String getCodigoIsbn() {
        return codigoIsbn;
    }

    public void setCodigoIsbn(String codigoIsbn) {
        this.codigoIsbn = codigoIsbn;
    }

    public String getEditorCompilador() {
        return editorCompilador;
    }

    public void setEditorCompilador(String editorCompilador) {
        this.editorCompilador = editorCompilador;
    }

    public String getPaginas() {
        return paginas;
    }

    public void setPaginas(String paginas) {
        this.paginas = paginas;
    }

    public String getFechaPublicacion() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String strDate = dateFormat.format(fechaPublicacion);
        return strDate;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public String getLinkPublicacion() {
        return linkPublicacion;
    }

    public void setLinkPublicacion(String linkPublicacion) {
        this.linkPublicacion = linkPublicacion;
    }

    public double getCampoDetallado() {
        return campoDetallado;
    }

    public void setCampoDetallado(double campoDetallado) {
        this.campoDetallado = campoDetallado;
    }

    public String getFiliacionUg() {
        return filiacionUg;
    }

    public void setFiliacionUg(String filiacionUg) {
        this.filiacionUg = filiacionUg;
    }

    public String getRevicionPorPares() {
        return revicionPorPares;
    }

    public void setRevicionPorPares(String revicionPorPares) {
        this.revicionPorPares = revicionPorPares;
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

    public Set<Usuario> getDocentes() {
        return docentes;
    }

    public void setDocentes(Set<Usuario> docentes) {
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
