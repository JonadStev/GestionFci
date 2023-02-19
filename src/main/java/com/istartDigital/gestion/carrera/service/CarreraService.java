package com.istartDigital.gestion.carrera.service;

import com.istartDigital.coreBussines.model.Cuenta;
import com.istartDigital.gestion.carrera.model.Carrera;

import java.util.List;
import java.util.Optional;

public interface CarreraService {

    Carrera saveCarrera(Carrera carrera);

    List<Carrera> getAllCarreras();

    Optional<Carrera> getCarreraById(long id);

}
