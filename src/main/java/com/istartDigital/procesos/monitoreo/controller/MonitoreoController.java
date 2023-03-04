package com.istartDigital.procesos.monitoreo.controller;

import com.istartDigital.gestion.lineaAndSubLinea.model.Linea;
import com.istartDigital.gestion.lineaAndSubLinea.service.LineaService;
import com.istartDigital.procesos.monitoreo.model.Monitoreo;
import com.istartDigital.procesos.monitoreo.service.MonitoreoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gestion/monitoreo")
@CrossOrigin
public class MonitoreoController {

    @Autowired
    MonitoreoService monitoreoService;

    @PostMapping("/save")
    public Monitoreo save(@RequestBody Monitoreo monitoreo) {
        return monitoreoService.saveMonitoreo(monitoreo);
    }

    @GetMapping("/all")
    public List<Monitoreo> getAll(){
        return monitoreoService.getAllMonitoreos();
    }
}
