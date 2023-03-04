package com.istartDigital.procesos.monitoreo.service;

import com.istartDigital.gestion.lineaAndSubLinea.model.Linea;
import com.istartDigital.gestion.lineaAndSubLinea.repository.LineaRepository;
import com.istartDigital.procesos.monitoreo.model.Monitoreo;
import com.istartDigital.procesos.monitoreo.repository.MonitoreoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MonitoreoService {

    @Autowired
    MonitoreoRepository monitoreoRepository;


    public Monitoreo saveMonitoreo(Monitoreo monitoreo) {
        return monitoreoRepository.save(monitoreo);
    }

    public List<Monitoreo> getAllMonitoreos() {
        return (List<Monitoreo>) monitoreoRepository.findAll();
    }


}
