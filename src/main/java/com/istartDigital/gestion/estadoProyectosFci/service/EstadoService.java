package com.istartDigital.gestion.estadoProyectosFci.service;

import com.istartDigital.gestion.estadoProyectosFci.model.Estado;
import com.istartDigital.gestion.lineaAndSubLinea.model.Linea;

import java.util.List;
import java.util.Optional;

public interface EstadoService {

    Estado saveEstado(Estado estado);

    List<Estado> getAllEstados();

    List<Estado> getAllEstadosByStatus(String estado);

    Optional<Estado> getEstadoById(long id);

}
