package com.istartDigital.gestion.lineaAndSubLinea.repository;

import com.istartDigital.gestion.lineaAndSubLinea.model.SubLinea;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubLineaRepository extends CrudRepository<SubLinea, Long> {
}
