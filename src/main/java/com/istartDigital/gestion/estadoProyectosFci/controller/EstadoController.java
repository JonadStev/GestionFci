package com.istartDigital.gestion.estadoProyectosFci.controller;

import com.istartDigital.gestion.estadoProyectosFci.model.Estado;
import com.istartDigital.gestion.estadoProyectosFci.service.EstadoService;
import com.istartDigital.gestion.lineaAndSubLinea.model.Linea;
import com.istartDigital.gestion.producto.model.Producto;
import com.istartDigital.procesos.proyectos.model.Proyecto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/gestion/estado")
@CrossOrigin
public class EstadoController {

    @Autowired
    EstadoService estadoService;

    @PostMapping("/save")
    public Estado save(@RequestBody Estado estado) {
        return estadoService.saveEstado(estado);
    }

    @GetMapping("/all")
    public List<Estado> getAll(){
        return estadoService.getAllEstados();
    }

    @GetMapping("/all/{estado}")
    public List<Estado> getByStatus(@PathVariable("estado") String estado) {
        return estadoService.getAllEstadosByStatus(estado);
    }

}
