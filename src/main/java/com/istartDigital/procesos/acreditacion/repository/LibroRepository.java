package com.istartDigital.procesos.acreditacion.repository;

import com.istartDigital.procesos.acreditacion.model.Libro;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepository extends CrudRepository<Libro, Long> {
}
