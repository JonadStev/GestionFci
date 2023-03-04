package com.istartDigital.gestion.lineaAndSubLinea.repository;

import com.istartDigital.gestion.lineaAndSubLinea.model.SubLinea;
import com.istartDigital.procesos.proyectos.model.Proyecto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubLineaRepository extends CrudRepository<SubLinea, Long> {

    List<SubLinea> findByLinea(int linea);
}
