package com.istartDigital.coreBussines.service;

import com.istartDigital.coreBussines.model.Mantenimiento;
import com.istartDigital.coreBussines.repository.MantenimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MantenimientoServiceImpl implements MantenimientoService{

    @Autowired
    MantenimientoRepository mantenimientoRepository;

    @Override
    public Mantenimiento saveMantenimiento(Mantenimiento mantenimiento) {
        return mantenimientoRepository.save(mantenimiento);
    }

    @Override
    public List<Mantenimiento> getMantenimientos() {
        return (List<Mantenimiento>) mantenimientoRepository.findAll();
    }

    @Override
    public boolean deleteMantenimiento(long id) {
        try {
            Mantenimiento mantenimiento = mantenimientoRepository.findById(id).get();
            mantenimientoRepository.delete(mantenimiento);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
