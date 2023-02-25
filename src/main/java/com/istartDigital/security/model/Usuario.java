package com.istartDigital.security.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.istartDigital.coreBussines.model.Cuenta;
import com.istartDigital.gestion.producto.model.Producto;
import com.istartDigital.procesos.horas.model.AsignacionHoras;
import com.istartDigital.procesos.horas.model.DetalleAsigancionHoras;
import com.istartDigital.procesos.proyectos.model.Proyecto;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "USUARIO")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;
    private String apellido;
    private String cedula;
    @Column(unique = true)
    private String email;
    private String telefono;
    private String password;
    private String estado;
    private int carrera;

    /*
    Relación muchos a muchos
    Un usuario puede tener varios roles, y un rol puede pertenecer a varios usuarios.
    Se creará una tabla intermedia llamada MDC_USUARIO_ROL donde se mapearán las columnas
    principales de las clases Usuario y Rol, tomando sud @Id de cada clase
    */
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(name = "USUARIO_ROL", joinColumns = @JoinColumn(name = "usuario_id"),
    inverseJoinColumns = @JoinColumn(name = "rol_id"))
    private Set<Rol> roles = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "director")
    private List<Proyecto> proyectos;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "director")
    private List<Producto> producto;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "director")
    private List<AsignacionHoras> horas;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "investigador")
    private List<DetalleAsigancionHoras> detalleHoras;

    public Usuario() {
    }

    public Usuario(String nombre, String apellido, String cedula, String email, String telefono, String password, String estado, int carrera) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.email = email;
        this.telefono = telefono;
        this.password = password;
        this.estado = estado;
        this.carrera = carrera;
    }

    /*
    public Usuario(String nombre, String email, String nombreUsuario, String password, String direccion, String estado) {
        this.nombre = nombre;
        this.email = email;
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.direccion = direccion;
        this.estado = estado;
    }
     */

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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Set<Rol> getRoles() {
        return roles;
    }

    public void setRoles(Set<Rol> roles) {
        this.roles = roles;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public int getCarrera() {
        return carrera;
    }

    public void setCarrera(int carrera) {
        this.carrera = carrera;
    }

    public void setProyectos(List<Proyecto> proyectos) {
        this.proyectos = proyectos;
    }

    public void setProducto(List<Producto> producto) {
        this.producto = producto;
    }

    public String getNombreCompleto (){return this.nombre + ' '+this.apellido;}

}
