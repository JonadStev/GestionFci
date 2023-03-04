package com.istartDigital.procesos.acreditacion.controller;

import com.istartDigital.procesos.acreditacion.model.Articulo;
import com.istartDigital.procesos.acreditacion.model.CapituloLibro;
import com.istartDigital.procesos.acreditacion.model.Libro;
import com.istartDigital.procesos.acreditacion.model.Ponencia;
import com.istartDigital.procesos.acreditacion.service.AcreditacionService;
import com.istartDigital.procesos.horas.model.AsignacionHoras;
import com.nimbusds.jose.shaded.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/gestion/acreditacion")
@CrossOrigin
public class AcreditacionController {

    @Autowired
    AcreditacionService acreditacionService;

    @PostMapping("/excel")
    public Map<String, String> readExcel(@RequestParam("fichero") MultipartFile file) {
        Map<String, String> map = new HashMap<>();
        try {
            InputStream inputStream = file.getInputStream();
            if(acreditacionService.readExcel(inputStream))
                map.put("message", "Procesado correctamente");
            else
                map.put("message", "Error al leer el archivo de Excel");

        } catch (IOException e) {
            e.printStackTrace();
            map.put("message", "Error al leer el archivo de Excel");
        }
        return map;
    }

    @PostMapping("/articulo/save")
    public Articulo saveArticulo(@RequestBody Articulo articulo) {
        return acreditacionService.saveArticulo(articulo);
    }

    @GetMapping("/articulo/all")
    public List<Articulo> getAllArticulos(){
        return acreditacionService.getAllArticulos();
    }

    @PostMapping("/ponencia/save")
    public Ponencia savePonencia(@RequestBody Ponencia ponencia) {
        return acreditacionService.savePonencia(ponencia);
    }

    @GetMapping("/ponencia/all")
    public List<Ponencia> getAllPonencias(){
        return acreditacionService.getAllPonencias();
    }

    @PostMapping("/libro/save")
    public Libro saveLibro(@RequestBody Libro libro) {
        return acreditacionService.saveLibro(libro);
    }

    @GetMapping("/libro/all")
    public List<Libro> getAllLibros(){
        return acreditacionService.getAllLibros();
    }

    @PostMapping("/capitulo-libro/save")
    public CapituloLibro saveCapLibro(@RequestBody CapituloLibro capLibro) {
        return acreditacionService.saveCapituloLibro(capLibro);
    }

    @GetMapping("/capitulo-libro/all")
    public List<CapituloLibro> getAllCapLibros(){
        return acreditacionService.getAllCapituloLibro();
    }

    //REPORTERIA
    @GetMapping("/articulo/allByfilter")
    public List<Articulo> getAllArticulosByFilter(@RequestParam(defaultValue = "NO_EDIT", name = "tipoPublicacion") String tipoPublicacion,
                                          @RequestParam(defaultValue = "NO_EDIT", name = "codigoPublicacion") String codigoPublicacion,
                                          @RequestParam(defaultValue = "2070-12-01", name = "fechaPublicacion") String fechaPublicacion,
                                          @RequestParam(defaultValue = "0", name = "docente") long docente){

        if(tipoPublicacion.equalsIgnoreCase("NO_EDIT") && codigoPublicacion.equalsIgnoreCase("NO_EDIT") && fechaPublicacion.equalsIgnoreCase("2070-12-01") && docente != 0){
            System.out.println("Se esta enviando solo el docente a buscar");
            return acreditacionService.getAllArticulosByDocente(docente);
        }else if((!tipoPublicacion.equalsIgnoreCase("NO_EDIT") || !codigoPublicacion.equalsIgnoreCase("NO_EDIT") || !fechaPublicacion.equalsIgnoreCase("2070-12-01")) && docente == 0){
            return acreditacionService.getAllArticulosByFilter(tipoPublicacion,codigoPublicacion,fechaPublicacion);
        }else if((!tipoPublicacion.equalsIgnoreCase("NO_EDIT") || !codigoPublicacion.equalsIgnoreCase("NO_EDIT") || !fechaPublicacion.equalsIgnoreCase("2070-12-01")) && docente != 0){
            return acreditacionService.getAllArticulosByFilterAndDocente(tipoPublicacion,codigoPublicacion,fechaPublicacion,docente);
        }else {
            return null;
        }
    }

    @GetMapping("/ponencia/allByfilter")
    public List<Ponencia> getAllPonenciasByFilter(@RequestParam(defaultValue = "NO_EDIT", name = "tipoPublicacion") String tipoPublicacion,
                                                  @RequestParam(defaultValue = "NO_EDIT", name = "codigoPublicacion") String codigoPublicacion,
                                                  @RequestParam(defaultValue = "2070-12-01", name = "fechaPublicacion") String fechaPublicacion,
                                                  @RequestParam(defaultValue = "0", name = "docente") long docente){

        if(tipoPublicacion.equalsIgnoreCase("NO_EDIT") && codigoPublicacion.equalsIgnoreCase("NO_EDIT") && fechaPublicacion.equalsIgnoreCase("2070-12-01") && docente != 0){
            return acreditacionService.getAllPonenciasByDocente(docente);
        }else if((!tipoPublicacion.equalsIgnoreCase("NO_EDIT") || !codigoPublicacion.equalsIgnoreCase("NO_EDIT") || !fechaPublicacion.equalsIgnoreCase("2070-12-01")) && docente == 0){
            return acreditacionService.getAllPonenciasByFilter(tipoPublicacion,codigoPublicacion,fechaPublicacion);
        }else if((!tipoPublicacion.equalsIgnoreCase("NO_EDIT") || !codigoPublicacion.equalsIgnoreCase("NO_EDIT") || !fechaPublicacion.equalsIgnoreCase("2070-12-01")) && docente != 0){
            return acreditacionService.getAllPonenciasByFilterAndDocente(tipoPublicacion,codigoPublicacion,fechaPublicacion,docente);
        }else {
            return null;
        }
    }

    @GetMapping("/libro/allByfilter")
    public List<Libro> getAllLibrosByFilter(@RequestParam(defaultValue = "NO_EDIT", name = "tipoPublicacion") String tipoPublicacion,
                                                  @RequestParam(defaultValue = "NO_EDIT", name = "codigoPublicacion") String codigoPublicacion,
                                                  @RequestParam(defaultValue = "2070-12-01", name = "fechaPublicacion") String fechaPublicacion,
                                                  @RequestParam(defaultValue = "0", name = "docente") long docente){

        if(tipoPublicacion.equalsIgnoreCase("NO_EDIT") && codigoPublicacion.equalsIgnoreCase("NO_EDIT") && fechaPublicacion.equalsIgnoreCase("2070-12-01") && docente != 0){
            return acreditacionService.getAllLibrosByDocente(docente);
        }else if((!tipoPublicacion.equalsIgnoreCase("NO_EDIT") || !codigoPublicacion.equalsIgnoreCase("NO_EDIT") || !fechaPublicacion.equalsIgnoreCase("2070-12-01")) && docente == 0){
            return acreditacionService.getAllLibrosByFilter(tipoPublicacion,codigoPublicacion,fechaPublicacion);
        }else if((!tipoPublicacion.equalsIgnoreCase("NO_EDIT") || !codigoPublicacion.equalsIgnoreCase("NO_EDIT") || !fechaPublicacion.equalsIgnoreCase("2070-12-01")) && docente != 0){
            return acreditacionService.getAllLibrosByFilterAndDocente(tipoPublicacion,codigoPublicacion,fechaPublicacion,docente);
        }else {
            return null;
        }
    }

    @GetMapping("/capitulo/allByfilter")
    public List<CapituloLibro> getAllCapituloLibroByFilter(@RequestParam(defaultValue = "NO_EDIT", name = "tipoPublicacion") String tipoPublicacion,
                                            @RequestParam(defaultValue = "NO_EDIT", name = "codigoPublicacion") String codigoPublicacion,
                                            @RequestParam(defaultValue = "2070-12-01", name = "fechaPublicacion") String fechaPublicacion,
                                            @RequestParam(defaultValue = "0", name = "docente") long docente){

        if(tipoPublicacion.equalsIgnoreCase("NO_EDIT") && codigoPublicacion.equalsIgnoreCase("NO_EDIT") && fechaPublicacion.equalsIgnoreCase("2070-12-01") && docente != 0){
            return acreditacionService.getAllCapitulosLibroByDocente(docente);
        }else if((!tipoPublicacion.equalsIgnoreCase("NO_EDIT") || !codigoPublicacion.equalsIgnoreCase("NO_EDIT") || !fechaPublicacion.equalsIgnoreCase("2070-12-01")) && docente == 0){
            return acreditacionService.getAllCapitulosLibroByFilter(tipoPublicacion,codigoPublicacion,fechaPublicacion);
        }else if((!tipoPublicacion.equalsIgnoreCase("NO_EDIT") || !codigoPublicacion.equalsIgnoreCase("NO_EDIT") || !fechaPublicacion.equalsIgnoreCase("2070-12-01")) && docente != 0){
            return acreditacionService.getAllCapitulosLibroByFilterAndDocente(tipoPublicacion,codigoPublicacion,fechaPublicacion,docente);
        }else {
            return null;
        }
    }
}
