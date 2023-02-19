package com.istartDigital.gestion.unesco.repository;

import com.istartDigital.gestion.unesco.model.Unesco;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnescoRepository extends CrudRepository<Unesco, Long> {
}
