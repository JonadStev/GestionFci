package com.istartDigital.gestion.estadoProyectosFci.repository;

import com.istartDigital.gestion.estadoProyectosFci.model.Estado;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends CrudRepository<Estado, Long> {
}
