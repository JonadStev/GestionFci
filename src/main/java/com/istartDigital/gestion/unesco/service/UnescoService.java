package com.istartDigital.gestion.unesco.service;

import com.istartDigital.gestion.carrera.model.Carrera;
import com.istartDigital.gestion.unesco.model.Unesco;

import java.util.List;
import java.util.Optional;

public interface UnescoService {

    Unesco saveUnesco(Unesco unesco);

    List<Unesco> getAllUnesco();

    Optional<Unesco> getUnescoById(long id);

}
