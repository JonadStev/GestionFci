package com.istartDigital.procesos.monitoreo.repository;

import com.istartDigital.procesos.monitoreo.model.Monitoreo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonitoreoRepository extends CrudRepository<Monitoreo, Long> {
}
