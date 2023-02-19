package com.istartDigital.gestion.lineaAndSubLinea.controller;

import com.istartDigital.gestion.lineaAndSubLinea.model.Linea;
import com.istartDigital.gestion.lineaAndSubLinea.service.LineaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gestion/linea")
@CrossOrigin
public class LineaController {

    @Autowired
    LineaService lineaService;

    @PostMapping("/save")
    public Linea save(@RequestBody Linea linea) {
        return lineaService.saveLinea(linea);
    }

    @GetMapping("/all")
    public List<Linea> getAll(){
        return lineaService.getAllLineas();
    }

}
