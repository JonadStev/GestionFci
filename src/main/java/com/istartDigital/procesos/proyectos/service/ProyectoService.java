package com.istartDigital.procesos.proyectos.service;

import com.istartDigital.procesos.proyectos.dto.ProyectoDto;
import com.istartDigital.procesos.proyectos.model.Proyecto;
import com.istartDigital.procesos.proyectos.repository.ProyectoRepository;
import com.istartDigital.security.model.Usuario;
import com.istartDigital.security.repository.UsuarioRepository;
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

    @Autowired
    UsuarioRepository usuarioRepository;

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

    public List<Proyecto> getAllProyectosByFilter(String fechaInicio, String fechaFin){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date dInicio = null;
        Date dFinal = null;
        try {
            dInicio = formatter.parse(fechaInicio);
            dFinal = formatter.parse(fechaFin);
        }catch (Exception e){
            System.out.println(e);
        }
        return (List<Proyecto>) proyectoRepository.findByFechaInicioAndFechaFin(dInicio,dFinal);
    }

    public List<Proyecto> getAllProyectosByFilter(String fechaInicio, String fechaFin, String estado){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date dInicio = null;
        Date dFinal = null;
        try {
            dInicio = formatter.parse(fechaInicio);
            dFinal = formatter.parse(fechaFin);
        }catch (Exception e){
            System.out.println(e);
        }
        return (List<Proyecto>) proyectoRepository.findByFechaInicioAndFechaFinAndEstado(dInicio,dFinal,estado);
    }

    public List<Proyecto> getAllProyectosByFilter(String fechaInicio, String fechaFin, String estado, long director){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date dInicio = null;
        Date dFinal = null;
        try {
            dInicio = formatter.parse(fechaInicio);
            dFinal = formatter.parse(fechaFin);
        }catch (Exception e){
            System.out.println(e);
        }
        Optional<Usuario> direc = usuarioRepository.findById(director);
        return (List<Proyecto>) proyectoRepository.findByFechaInicioAndFechaFinAndEstadoAndDirector(dInicio,dFinal,estado,direc.get());
    }

    public List<Proyecto> getAllProyectosByFilter(String estado, long director){
        Optional<Usuario> direc = usuarioRepository.findById(director);
        return (List<Proyecto>) proyectoRepository.findByEstadoAndDirector(estado,direc.get());
    }

    public List<Proyecto> getAllProyectosByFilter(String fechaInicio, String fechaFin, long director){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date dInicio = null;
        Date dFinal = null;
        try {
            dInicio = formatter.parse(fechaInicio);
            dFinal = formatter.parse(fechaFin);
        }catch (Exception e){
            System.out.println(e);
        }
        Optional<Usuario> direc = usuarioRepository.findById(director);
        return (List<Proyecto>) proyectoRepository.findByFechaInicioAndFechaFinAndDirector(dInicio,dFinal,direc.get());
    }

    public List<Proyecto> getAllProyectosByFilter(long director){
        Optional<Usuario> direc = usuarioRepository.findById(director);
        if (direc.isEmpty()){
            System.out.println("No se ha encontrado el director");
            return null;
        }
        return (List<Proyecto>) proyectoRepository.findByDirector(direc.get());
    }

    public Optional<Proyecto> getProyectoById(long id){
        return proyectoRepository.findById(id);
    }
}
