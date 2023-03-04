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

    @GetMapping("/allFilter")
    public List<Proyecto> getAllByFilter(@RequestParam(defaultValue = "", name = "fechaInicio") String fechaInicio,
                                        @RequestParam(defaultValue = "", name = "fechaFin") String fechaFin,
                                        @RequestParam(defaultValue = "", name = "estado") String estado,
                                        @RequestParam(defaultValue = "0", name = "director") long director){

        if (!fechaInicio.isEmpty() && !fechaFin.isEmpty() && !estado.isEmpty() && director != 0){
            System.out.println("if 1");
            return proyectoService.getAllProyectosByFilter(fechaInicio,fechaFin, estado, director);
        }else if (!fechaInicio.isEmpty() && !fechaFin.isEmpty() && estado.isEmpty() && director == 0){
            System.out.println("if 2.0");
            return proyectoService.getAllProyectosByFilter(fechaInicio,fechaFin);
        }else if (!fechaInicio.isEmpty() && !fechaFin.isEmpty() && !estado.isEmpty()){
            System.out.println("if 2");
            return proyectoService.getAllProyectosByFilter(fechaInicio,fechaFin, estado);
        }else if (!fechaInicio.isEmpty() && !fechaFin.isEmpty() && director != 0){
            System.out.println("if 3");
            return proyectoService.getAllProyectosByFilter(fechaInicio,fechaFin, director);
        }else if (fechaInicio.isEmpty() && fechaFin.isEmpty() && !estado.isEmpty() && director != 0){
            System.out.println("if 4");
            return proyectoService.getAllProyectosByFilter(estado, director);
        }else if (fechaInicio.isEmpty() && fechaFin.isEmpty() && !estado.isEmpty() && director == 0){
            System.out.println("if 5");
            return proyectoService.getProyectosByStatus(estado);
        }else if (fechaInicio.isEmpty() && fechaFin.isEmpty() && estado.isEmpty() && director != 0){
            System.out.println("if 6");
            return proyectoService.getAllProyectosByFilter(director);
        }else {return null;}
    }

    @GetMapping("/{id}")
    public Optional<Proyecto> getById(@PathVariable("id") long id){
        return proyectoService.getProyectoById(id);
    }

}
