package com.istartDigital.gestion.lineaAndSubLinea.service;

import com.istartDigital.gestion.lineaAndSubLinea.model.SubLinea;

import java.util.List;
import java.util.Optional;

public interface SubLineaService {

    SubLinea saveSubLinea(SubLinea subLinea);

    List<SubLinea> getAllSubLineas();

    Optional<SubLinea> getSubLineaById(long id);

}
