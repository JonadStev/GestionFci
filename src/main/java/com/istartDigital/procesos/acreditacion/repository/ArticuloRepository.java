package com.istartDigital.procesos.acreditacion.repository;

import com.istartDigital.procesos.acreditacion.model.Articulo;
import com.istartDigital.procesos.proyectos.model.Proyecto;
import com.istartDigital.security.model.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ArticuloRepository extends CrudRepository<Articulo, Long> {
    List<Articulo> findByTipoPublicacionOrCodigoPublicacionOrFechaPublicacion(String tipoPublicacion,String codigoPublicacion, Date fechaPublicacion);

}
