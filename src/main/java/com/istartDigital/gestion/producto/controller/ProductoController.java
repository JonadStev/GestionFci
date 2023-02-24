package com.istartDigital.gestion.producto.controller;

import com.istartDigital.gestion.producto.model.Producto;
import com.istartDigital.gestion.producto.service.ProductoService;
import com.istartDigital.procesos.proyectos.dto.ProyectoDto;
import com.istartDigital.procesos.proyectos.model.Proyecto;
import com.istartDigital.procesos.proyectos.service.ProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/gestion/producto")
@CrossOrigin
public class ProductoController {

    @Autowired
    ProductoService productoService;

    @PostMapping("/save")
    public Producto save(@RequestBody Producto producto) {
        return productoService.saveProducto(producto);
    }

    @GetMapping("/all")
    public List<Producto> getAll(){
        return productoService.getAllProductos();
    }

    @GetMapping("/{id}")
    public Optional<Producto> getById(@PathVariable("id") long id){
        return productoService.getProductoById(id);
    }
}
