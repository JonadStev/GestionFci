package com.istartDigital.procesos.acreditacion.repository;

import com.istartDigital.procesos.acreditacion.model.Articulo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticuloRepository extends CrudRepository<Articulo, Long> {
}
