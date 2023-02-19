package com.istartDigital.gestion.lineaAndSubLinea.service;

import com.istartDigital.gestion.lineaAndSubLinea.model.Linea;

import java.util.List;
import java.util.Optional;

public interface LineaService {

    Linea saveLinea(Linea linea);

    List<Linea> getAllLineas();

    Optional<Linea> getLineaById(long id);

}
