package com.istartDigital.gestion.carrera.service;

import com.istartDigital.gestion.carrera.model.Carrera;
import com.istartDigital.gestion.carrera.repository.CarreraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarreraServiceImpl implements CarreraService{

    @Autowired
    CarreraRepository carreraRepository;

    @Override
    public Carrera saveCarrera(Carrera carrera) {
        return carreraRepository.save(carrera);
    }

    @Override
    public List<Carrera> getAllCarreras() {
        return (List<Carrera>) carreraRepository.findAll();
    }

    @Override
    public Optional<Carrera> getCarreraById(long id) {
        return carreraRepository.findById(id);
    }
}
