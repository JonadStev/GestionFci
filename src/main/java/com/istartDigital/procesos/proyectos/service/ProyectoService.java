package com.istartDigital.procesos.proyectos.service;

import com.istartDigital.gestion.carrera.model.Carrera;
import com.istartDigital.procesos.proyectos.dto.ProyectoDto;
import com.istartDigital.procesos.proyectos.model.Proyecto;
import com.istartDigital.procesos.proyectos.repository.ProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProyectoService {

    @Autowired
    ProyectoRepository proyectoRepository;

    public Proyecto saveProyecto(ProyectoDto proyecto){

        Proyecto pry = new Proyecto();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaInicio = null;
        Date fechaFin = null;
        try {
            fechaInicio = formatter.parse(proyecto.getFechaInicio());
            fechaFin = formatter.parse(proyecto.getFechaFin());
        }catch (Exception e){
            System.out.println(e);
        }

        if (proyecto.getId() != 0){
            //es un edit
            pry.setId(proyecto.getId());
        }

        pry.setIdProyecto(proyecto.getIdProyecto());
        pry.setNombre(proyecto.getNombre());
        pry.setConvocatoria(proyecto.getConvocatoria());
        pry.setEstado(proyecto.getEstado());
        pry.setFechaInicio(fechaInicio);
        pry.setFechaFin(fechaFin);
        pry.setDirector(proyecto.getDirector());
        pry.setInvestigadores(proyecto.getInvestigadores());
        pry.setCorreoDirector(proyecto.getCorreoDirector());
        pry.setTelefonoDirector(proyecto.getTelefonoDirector());

        return proyectoRepository.save(pry);
    }

    public List<Proyecto> getAllProyectos(){
        return (List<Proyecto>) proyectoRepository.findAll();
    }

    public List<Proyecto> getProyectosByStatus(String estado){
        return (List<Proyecto>) proyectoRepository.findByEstado(estado);
    }

    public Optional<Proyecto> getProyectoById(long id){
        return proyectoRepository.findById(id);
    }
}
