package com.istartDigital.gestion.estadoProyectosFci.repository;

import com.istartDigital.gestion.estadoProyectosFci.model.Estado;
import com.istartDigital.procesos.proyectos.model.Proyecto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstadoRepository extends CrudRepository<Estado, Long> {

    List<Estado> findByEstado(String estado);
}
