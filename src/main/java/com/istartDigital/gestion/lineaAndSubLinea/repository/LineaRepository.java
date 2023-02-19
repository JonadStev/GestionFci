package com.istartDigital.gestion.lineaAndSubLinea.repository;

import com.istartDigital.gestion.lineaAndSubLinea.model.Linea;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LineaRepository extends CrudRepository<Linea, Long> {
}
