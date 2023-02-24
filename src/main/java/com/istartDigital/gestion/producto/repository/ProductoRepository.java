package com.istartDigital.gestion.producto.repository;

import com.istartDigital.gestion.producto.model.Producto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends CrudRepository<Producto, Long> {
}
