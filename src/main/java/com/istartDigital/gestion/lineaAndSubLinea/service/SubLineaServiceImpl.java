package com.istartDigital.gestion.lineaAndSubLinea.service;

import com.istartDigital.gestion.lineaAndSubLinea.model.SubLinea;
import com.istartDigital.gestion.lineaAndSubLinea.repository.SubLineaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubLineaServiceImpl implements SubLineaService{

    @Autowired
    SubLineaRepository subLineaRepository;

    @Override
    public SubLinea saveSubLinea(SubLinea subLinea) {
        return subLineaRepository.save(subLinea);
    }

    @Override
    public List<SubLinea> getAllSubLineas() {
        return (List<SubLinea>) subLineaRepository.findAll();
    }

    @Override
    public Optional<SubLinea> getSubLineaById(long id) {
        return subLineaRepository.findById(id);
    }

    @Override
    public List<SubLinea> getAllSubLineasByLinea(int id) {
        return subLineaRepository.findByLinea(id);
    }
}
