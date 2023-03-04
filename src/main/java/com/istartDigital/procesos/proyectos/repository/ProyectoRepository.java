package com.istartDigital.procesos.proyectos.repository;

import com.istartDigital.gestion.carrera.model.Carrera;
import com.istartDigital.procesos.proyectos.model.Proyecto;
import com.istartDigital.security.model.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ProyectoRepository extends CrudRepository<Proyecto, Long> {
    List<Proyecto> findByEstado(String estado);
    List<Proyecto> findByDirector(Usuario director);
    List<Proyecto> findByFechaInicioAndFechaFin(Date desde, Date hasta);
    List<Proyecto> findByFechaInicioAndFechaFinAndEstado(Date desde, Date hasta, String estado);
    List<Proyecto> findByFechaInicioAndFechaFinAndEstadoAndDirector(Date desde, Date hasta, String estado, Usuario director);
    List<Proyecto> findByEstadoAndDirector(String estado, Usuario director);
    List<Proyecto> findByFechaInicioAndFechaFinAndDirector(Date desde, Date hasta, Usuario director);
}
