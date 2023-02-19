package com.istartDigital.coreBussines.service;

import com.istartDigital.coreBussines.dto.BloqueoDto;
import com.istartDigital.coreBussines.dto.DataSets;
import com.istartDigital.coreBussines.dto.ReporteCuentasBaneadasPorFechaDto;
import com.istartDigital.coreBussines.model.Bloqueo;
import com.istartDigital.coreBussines.model.Cuenta;
import com.istartDigital.coreBussines.repository.BloqueoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class BloqueoServiceImpl implements BloqueoService{

    @Autowired
    BloqueoRepository bloqueoRepository;

    @Autowired
    CuentaService cuentaService;

    @Override
    public Bloqueo saveBloqueo(BloqueoDto bloqueo) {
        //Acualizar estao de la cuenta a BLOQUEADA
        Optional<Cuenta> cuenta = cuentaService.getCuentaById(bloqueo.getCuenta());
        cuenta.get().setEstado(bloqueo.getEstadoR2());
        cuentaService.saveCuenta(cuenta.get());

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaPrimeraRevision = null;
        Date fechaSegundaRevision = null;
        try {
            fechaPrimeraRevision = formatter.parse(bloqueo.getFechaPrimeraRevision());
            fechaSegundaRevision = formatter.parse(bloqueo.getFechaSegundaRevision());
        }catch (Exception e){
            System.out.println(e);
        }

        Bloqueo b = new Bloqueo(bloqueo.getUsuario(),
                bloqueo.getEstadoR1(),
                fechaPrimeraRevision,
                bloqueo.getEstadoR2(),
                fechaSegundaRevision,
                bloqueo.getMotivo(),
                bloqueo.getDias(),
                bloqueo.getBloque(),
                bloqueo.getCuenta());

        return bloqueoRepository.save(b);
    }

    @Override
    public List<Bloqueo> getBloqueos() {
        return (List<Bloqueo>) bloqueoRepository.findAll();
    }

    @Override
    public boolean deleteBloqueo(long id) {
        try {
            Bloqueo bloqueo = bloqueoRepository.findById(id).get();

            Optional<Cuenta> cuenta = cuentaService.getCuentaById(bloqueo.getCuenta());
            cuenta.get().setEstado("ACTIVO");
            cuentaService.saveCuenta(cuenta.get());

            bloqueoRepository.delete(bloqueo);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public ReporteCuentasBaneadasPorFechaDto getCuentasBaneadasByFecha(String fechaIni, String fechaFin) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date dInicio = null;
        Date dFinal = null;
        try {
            dInicio = formatter.parse(fechaIni);
            dFinal = formatter.parse(fechaFin);
        }catch (Exception e){
            System.out.println(e);
        }

        List<Bloqueo> listaBloqueos = bloqueoRepository.findByFechaSegundaRevisionBetween(dInicio, dFinal);

        List<Long> bloques = listaBloqueos.stream().map(x -> x.getBloque()).collect(Collectors.toList());

        Set<Long> miSet = new HashSet<Long>(bloques);

        List<ReporteCuentasBaneadasPorFechaDto> reporte = new ArrayList<>();
        String [] labels = new String[miSet.size()];
        Integer [] datasets = new Integer[miSet.size()];
        // long s: miSet <>
        int contador = 0;
        for(long s: miSet){
            System.out.println(s + " " +Collections.frequency(bloques,s));
            labels[contador] = "Bloque "+s;
            datasets[contador] = Collections.frequency(bloques,s);
            contador++;
        }
        return new ReporteCuentasBaneadasPorFechaDto(labels,new DataSets(datasets));
    }

    @Override
    public Integer[] getCuentasGenerales() {
        //Cuentas registadas
        //Cuentas baneadas
        //Cuentas Activas
        int cuentasRegistradas = cuentaService.getAllCuentas().size();
        int cuentasBaneadas = cuentaService.getAllCuentas()
                .stream()
                .filter(x -> x.getEstado().equalsIgnoreCase("BLOQUEADA"))
                .collect(Collectors.toList()).size();
        int cuentasActivas = cuentaService.getAllCuentas()
                .stream()
                .filter(x -> x.getEstado().equalsIgnoreCase("ACTIVO"))
                .collect(Collectors.toList()).size();
        Integer [] datos = new Integer[3];
        datos[0] = cuentasRegistradas;
        datos[1] = cuentasBaneadas;
        datos[2] = cuentasActivas;
        return datos;
    }
}
