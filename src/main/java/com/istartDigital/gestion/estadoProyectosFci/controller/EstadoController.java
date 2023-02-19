package com.istartDigital.gestion.estadoProyectosFci.controller;

import com.istartDigital.gestion.estadoProyectosFci.model.Estado;
import com.istartDigital.gestion.estadoProyectosFci.service.EstadoService;
import com.istartDigital.gestion.lineaAndSubLinea.model.Linea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

}
