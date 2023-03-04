package com.istartDigital.procesos.acreditacion.repository;

import com.istartDigital.procesos.acreditacion.model.Articulo;
import com.istartDigital.procesos.acreditacion.model.Ponencia;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PonenciaRepository extends CrudRepository<Ponencia, Long> {
    List<Ponencia> findByTipoPublicacionOrCodigoPublicacionOrFechaPublicacion(String tipoPublicacion, String codigoPublicacion, Date fechaPublicacion);
}
