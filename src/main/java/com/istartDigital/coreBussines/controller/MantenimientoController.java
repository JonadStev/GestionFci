package com.istartDigital.coreBussines.controller;

import com.istartDigital.coreBussines.model.Mantenimiento;
import com.istartDigital.coreBussines.service.MantenimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("mantenimientos")
@CrossOrigin
public class MantenimientoController {

    @Autowired
    MantenimientoService mantenimientoService;

    @PreAuthorize("hasRole('ROLE_SUPERVISOR') or hasRole('ROLE_MANTENIMIENTO')")
    @PostMapping("/save")
    public Mantenimiento save(@RequestBody Mantenimiento mantenimiento){
        return mantenimientoService.saveMantenimiento(mantenimiento);
    }

    @PreAuthorize("hasRole('ROLE_SUPERVISOR') or hasRole('ROLE_MANTENIMIENTO')")
    @GetMapping("/all")
    public List<Mantenimiento> getAll(){
        return mantenimientoService.getMantenimientos();
    }

    @PreAuthorize("hasRole('ROLE_SUPERVISOR') or hasRole('ROLE_MANTENIMIENTO')")
    @DeleteMapping("/delete/{id}")
    public Map<String, String> delete(@PathVariable("id") long id){
        Map<String, String> map = new HashMap<>();
        if(mantenimientoService.deleteMantenimiento(id))
            map.put("message", "Se ha eliminado el mantenimiento.");
        else
            map.put("message", "No se ha podido eliminar el mantenimiento.");
        return map;
    }

}
