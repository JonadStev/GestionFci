package com.istartDigital.gestion.carrera.repository;

import com.istartDigital.gestion.carrera.model.Carrera;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarreraRepository extends CrudRepository<Carrera, Long> {

}
