package com.istartDigital.gestion.producto.model;

import com.istartDigital.gestion.producto.model.Producto;

import javax.persistence.*;

@Entity
@Table(name = "CONOCIMIENTO")
public class Conocimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String grupos;
    private String redes;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "conocimientoPropuesto")
    private Producto productoPropuesto;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "conocimientoCumplido")
    private Producto productoCumplido;

    public Conocimiento() {
    }

    public Conocimiento(String grupos, String redes) {
        this.grupos = grupos;
        this.redes = redes;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGrupos() {
        return grupos;
    }

    public void setGrupos(String grupos) {
        this.grupos = grupos;
    }

    public String getRedes() {
        return redes;
    }

    public void setRedes(String redes) {
        this.redes = redes;
    }
}
