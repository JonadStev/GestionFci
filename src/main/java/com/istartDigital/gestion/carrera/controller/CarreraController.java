package com.istartDigital.gestion.carrera.controller;

import com.istartDigital.gestion.carrera.model.Carrera;
import com.istartDigital.gestion.carrera.service.CarreraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gestion/carrera")
@CrossOrigin
public class CarreraController {

    @Autowired
    CarreraService carreraService;

    @PostMapping("/save")
    public Carrera save(@RequestBody Carrera carrera) {
        return carreraService.saveCarrera(carrera);
    }

    @GetMapping("/all")
    public List<Carrera> getAll(){
        return carreraService.getAllCarreras();
    }

}
