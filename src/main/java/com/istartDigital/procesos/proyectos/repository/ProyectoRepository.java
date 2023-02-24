package com.istartDigital.procesos.proyectos.repository;

import com.istartDigital.gestion.carrera.model.Carrera;
import com.istartDigital.procesos.proyectos.model.Proyecto;
import com.istartDigital.security.model.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProyectoRepository extends CrudRepository<Proyecto, Long> {
    List<Proyecto> findByEstado(String estado);
}
