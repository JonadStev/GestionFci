package com.istartDigital.procesos.horas.service;

import com.istartDigital.procesos.horas.model.AsignacionHoras;
import com.istartDigital.procesos.horas.model.DetalleAsigancionHoras;
import com.istartDigital.procesos.horas.repository.AsignacionHorasRepository;
import com.istartDigital.procesos.proyectos.dto.ProyectoDto;
import com.istartDigital.procesos.proyectos.model.Proyecto;
import com.istartDigital.procesos.proyectos.repository.ProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AsignacionHorasService {

    @Autowired
    AsignacionHorasRepository asignacionHorasRepository;

    public AsignacionHoras saveHoras(AsignacionHoras asignacionHoras) {
        if (asignacionHoras.getId() == 0){
            System.out.println("Es uno nuevo");
            AsignacionHoras asNew = new AsignacionHoras(asignacionHoras.getProyecto(),asignacionHoras.getNombreProyecto(),asignacionHoras.getConvocatoria(),asignacionHoras.getDirector(),asignacionHoras.getInforme());
            List<DetalleAsigancionHoras> detalles = new ArrayList<>();
            for (DetalleAsigancionHoras d: asignacionHoras.getDetalle()) {
                d.setHoras(asNew);
                detalles.add(d);
            }
            asNew.setDetalle(detalles);
            return asignacionHorasRepository.save(asNew);
        }else {
            System.out.println("No es uno nuevo");

            AsignacionHoras asAct = asignacionHoras;
            List<DetalleAsigancionHoras> detalles = new ArrayList<>();
            for (DetalleAsigancionHoras d: asignacionHoras.getDetalle()) {
                d.setHoras(asAct);
                detalles.add(d);
            }
            asAct.setDetalle(detalles);
            return asignacionHorasRepository.save(asignacionHoras);
        }

    }

    public List<AsignacionHoras> getAllHoras(){
        return (List<AsignacionHoras>) asignacionHorasRepository.findAll();
    }

}
