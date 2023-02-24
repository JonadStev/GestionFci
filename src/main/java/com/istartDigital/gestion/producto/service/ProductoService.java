package com.istartDigital.gestion.producto.service;

import com.istartDigital.gestion.lineaAndSubLinea.model.Linea;
import com.istartDigital.gestion.lineaAndSubLinea.repository.LineaRepository;
import com.istartDigital.gestion.producto.model.Producto;
import com.istartDigital.gestion.producto.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    ProductoRepository productoRepository;


    public Producto saveProducto(Producto producto) {
        return productoRepository.save(producto);
    }


    public List<Producto> getAllProductos() {
        return (List<Producto>) productoRepository.findAll();
    }


    public Optional<Producto> getProductoById(long id) {
        return productoRepository.findById(id);
    }

}
