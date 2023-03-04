package com.istartDigital.procesos.acreditacion.repository;

import com.istartDigital.procesos.acreditacion.model.CapituloLibro;
import com.istartDigital.procesos.acreditacion.model.Libro;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CapituloLibroRepository extends CrudRepository<CapituloLibro, Long> {
    List<CapituloLibro> findByTipoPublicacionOrCodigoPublicacionOrFechaPublicacion(String tipoPublicacion, String codigoPublicacion, Date fechaPublicacion);
}
