package com.istartDigital.coreBussines.repository;

import com.istartDigital.coreBussines.model.Mantenimiento;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MantenimientoRepository extends CrudRepository<Mantenimiento, Long> {
}
