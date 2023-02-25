package com.istartDigital.procesos.horas.controller;

import com.istartDigital.procesos.horas.model.AsignacionHoras;
import com.istartDigital.procesos.horas.service.AsignacionHorasService;
import com.istartDigital.procesos.proyectos.dto.ProyectoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gestion/horas")
@CrossOrigin
public class AsignacionHorasController {

    @Autowired
    AsignacionHorasService asignacionHorasService;

    @PostMapping("/save")
    public AsignacionHoras save(@RequestBody AsignacionHoras horas) {
        return asignacionHorasService.saveHoras(horas);
    }

    @GetMapping("/all")
    public List<AsignacionHoras> getAll(){
        return asignacionHorasService.getAllHoras();
    }


}
