package com.istartDigital.gestion.unesco.service;

import com.istartDigital.gestion.unesco.model.Unesco;
import com.istartDigital.gestion.unesco.repository.UnescoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UnescoServiceImpl implements UnescoService{

    @Autowired
    UnescoRepository unescoRepository;

    @Override
    public Unesco saveUnesco(Unesco unesco) {
        return unescoRepository.save(unesco);
    }

    @Override
    public List<Unesco> getAllUnesco() {
        return (List<Unesco>) unescoRepository.findAll();
    }

    @Override
    public Optional<Unesco> getUnescoById(long id) {
        return unescoRepository.findById(id);
    }
}
