package com.istartDigital.procesos.horas.repository;

import com.istartDigital.procesos.horas.model.AsignacionHoras;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsignacionHorasRepository extends CrudRepository<AsignacionHoras, Long> {
}
