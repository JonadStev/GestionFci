package com.istartDigital.gestion.estadoProyectosFci.service;

import com.istartDigital.gestion.estadoProyectosFci.model.Estado;
import com.istartDigital.gestion.estadoProyectosFci.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadoServiceImpl implements EstadoService{

    @Autowired
    EstadoRepository estadoRepository;

    @Override
    public Estado saveEstado(Estado estado) {
        return estadoRepository.save(estado);
    }

    @Override
    public List<Estado> getAllEstados() {
        return (List<Estado>) estadoRepository.findAll();
    }

    @Override
    public Optional<Estado> getEstadoById(long id) {
        return estadoRepository.findById(id);
    }
}
