package com.istartDigital.procesos.proyectos.controller;

import com.istartDigital.gestion.carrera.model.Carrera;
import com.istartDigital.gestion.unesco.model.Unesco;
import com.istartDigital.procesos.proyectos.dto.ProyectoDto;
import com.istartDigital.procesos.proyectos.model.Proyecto;
import com.istartDigital.procesos.proyectos.service.ProyectoService;
import com.istartDigital.security.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/gestion/proyecto")
@CrossOrigin
public class ProyectoController {

    @Autowired
    ProyectoService proyectoService;

    @PostMapping("/save")
    public Proyecto save(@RequestBody ProyectoDto proyecto) {
        return proyectoService.saveProyecto(proyecto);
    }

    @GetMapping("/all")
    public List<Proyecto> getAll(){
        return proyectoService.getAllProyectos();
    }

    @GetMapping("/all/{estado}")
    public List<Proyecto> getProyectosByStatus(@PathVariable("estado") String estado) {
        return proyectoService.getProyectosByStatus(estado);
    }

    @GetMapping("/{id}")
    public Optional<Proyecto> getById(@PathVariable("id") long id){
        return proyectoService.getProyectoById(id);
    }

}
