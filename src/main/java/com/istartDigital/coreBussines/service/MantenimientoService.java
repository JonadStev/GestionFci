package com.istartDigital.coreBussines.service;

import com.istartDigital.coreBussines.model.Mantenimiento;

import java.util.List;

public interface MantenimientoService {

    Mantenimiento saveMantenimiento(Mantenimiento mantenimiento);

    List<Mantenimiento> getMantenimientos();

    boolean deleteMantenimiento(long id);

}
