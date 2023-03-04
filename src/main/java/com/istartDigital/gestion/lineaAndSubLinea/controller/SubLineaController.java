package com.istartDigital.gestion.lineaAndSubLinea.controller;

import com.istartDigital.gestion.lineaAndSubLinea.model.SubLinea;
import com.istartDigital.gestion.lineaAndSubLinea.service.SubLineaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gestion/sublinea")
@CrossOrigin
public class SubLineaController {

    @Autowired
    SubLineaService subLineaService;

    @PostMapping("/save")
    public SubLinea save(@RequestBody SubLinea subLinea) {
        return subLineaService.saveSubLinea(subLinea);
    }

    @GetMapping("/all")
    public List<SubLinea> getAll(){
        return subLineaService.getAllSubLineas();
    }

    @GetMapping("/all/{id}")
    public List<SubLinea> getAllByLinea(@PathVariable("id") int id){
        return subLineaService.getAllSubLineasByLinea(id);
    }

}
