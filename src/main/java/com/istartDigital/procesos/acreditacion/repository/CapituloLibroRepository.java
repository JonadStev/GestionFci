package com.istartDigital.procesos.acreditacion.repository;

import com.istartDigital.procesos.acreditacion.model.CapituloLibro;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CapituloLibroRepository extends CrudRepository<CapituloLibro, Long> {
}
