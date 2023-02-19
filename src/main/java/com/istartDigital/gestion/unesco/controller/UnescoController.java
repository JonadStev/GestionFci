package com.istartDigital.gestion.unesco.controller;

import com.istartDigital.gestion.unesco.model.Unesco;
import com.istartDigital.gestion.unesco.service.UnescoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/gestion/unesco")
@CrossOrigin
public class UnescoController {

    @Autowired
    UnescoService unescoService;

    @PostMapping("/save")
    public Unesco save(@RequestBody Unesco Unesco) {
        return unescoService.saveUnesco(Unesco);
    }

    @GetMapping("/all")
    public List<Unesco> getAll(){
        return unescoService.getAllUnesco();
    }

    @GetMapping("/{id}")
    public Optional<Unesco> getUnescoById(@PathVariable("id") long id){
        return unescoService.getUnescoById(id);
    }

}
