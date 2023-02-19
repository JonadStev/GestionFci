package com.istartDigital.gestion.lineaAndSubLinea.service;

import com.istartDigital.gestion.lineaAndSubLinea.model.Linea;
import com.istartDigital.gestion.lineaAndSubLinea.repository.LineaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LineaServiceImpl implements LineaService{

    @Autowired
    LineaRepository lineaRepository;

    @Override
    public Linea saveLinea(Linea linea) {
        return lineaRepository.save(linea);
    }

    @Override
    public List<Linea> getAllLineas() {
        return (List<Linea>) lineaRepository.findAll();
    }

    @Override
    public Optional<Linea> getLineaById(long id) {
        return lineaRepository.findById(id);
    }
}
