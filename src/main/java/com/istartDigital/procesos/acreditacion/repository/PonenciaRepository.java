package com.istartDigital.procesos.acreditacion.repository;

import com.istartDigital.procesos.acreditacion.model.Ponencia;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PonenciaRepository extends CrudRepository<Ponencia, Long> {
}
