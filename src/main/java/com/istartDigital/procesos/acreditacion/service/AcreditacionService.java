package com.istartDigital.procesos.acreditacion.service;

import com.istartDigital.procesos.acreditacion.model.Articulo;
import com.istartDigital.procesos.acreditacion.model.CapituloLibro;
import com.istartDigital.procesos.acreditacion.model.Libro;
import com.istartDigital.procesos.acreditacion.model.Ponencia;
import com.istartDigital.procesos.acreditacion.repository.ArticuloRepository;
import com.istartDigital.procesos.acreditacion.repository.CapituloLibroRepository;
import com.istartDigital.procesos.acreditacion.repository.LibroRepository;
import com.istartDigital.procesos.acreditacion.repository.PonenciaRepository;
import com.istartDigital.procesos.horas.model.AsignacionHoras;
import com.istartDigital.security.model.Usuario;
import com.istartDigital.security.service.UsuarioService;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class AcreditacionService {

    @Autowired
    private ArticuloRepository articuloRepository;
    @Autowired
    private PonenciaRepository ponenciaRepository;
    @Autowired
    private LibroRepository libroRepository;
    @Autowired
    private CapituloLibroRepository capituloLibroRepository;

    @Autowired
    UsuarioService usuarioService;

    public boolean readExcel(InputStream inputStream){
        try {
            Workbook workbook = WorkbookFactory.create(inputStream);
            Sheet sheet = workbook.getSheet("articulos");
            //Sheet sheet = workbook.getSheetAt("");
            int count = 0;
            for (Row row : sheet) {
                //ArrayList<Usuario> docentes = new ArrayList<>();
                Set<Usuario> docentes = new HashSet<>();
                if (count > 0){
                    if(row != null){
                        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                        Date fecha = null;
                        try {
                            if (row.getCell(13).getStringCellValue() != "" || row.getCell(13).getStringCellValue() != null){
                                fecha = formatter.parse(row.getCell(13).getStringCellValue());
                            }
                        }catch (Exception e){
                            System.out.println(e);
                        }
                        String facultad = (row.getCell(0) != null)?row.getCell(0).getStringCellValue():"";
                        String codigoUg = (row.getCell(1) != null)?row.getCell(1).getStringCellValue():"";
                        String tipoPublicacion = (row.getCell(2) != null)?row.getCell(2).getStringCellValue():"";
                        String codigoPublicacion = (row.getCell(3) != null)?row.getCell(3).getStringCellValue():"";
                        String tituloPublicacion = (row.getCell(4) != null)?row.getCell(4).getStringCellValue():"";
                        String doi = (row.getCell(5) != null)?row.getCell(5).getStringCellValue():"";
                        String baseDatosindexada = (row.getCell(6) != null)?row.getCell(6).getStringCellValue():"";
                        String codigoISSN = (row.getCell(7) != null)?row.getCell(7).getStringCellValue():"";
                        String tipoIndexacion = (row.getCell(8) != null)?row.getCell(8).getStringCellValue():"";
                        String nombreRevista = (row.getCell(9) != null)?row.getCell(9).getStringCellValue():"";
                        String numeroRevista = (row.getCell(10) != null)?row.getCell(10).getStringCellValue():"";
                        String quartil = (row.getCell(11) != null)?row.getCell(11).getStringCellValue():"";
                        String srjJcr = (row.getCell(12) != null)?row.getCell(12).getStringCellValue():"";
                        Date fechaPublicacion = fecha;
                        double campoDetallado = (row.getCell(14) != null)? row.getCell(14).getNumericCellValue():0;
                        String estado = (row.getCell(15) != null)?row.getCell(15).getStringCellValue():"";
                        String linkPublicacion = (row.getCell(16) != null)?row.getCell(16).getStringCellValue():"";
                        String linkRevista = (row.getCell(17) != null)?row.getCell(17).getStringCellValue():"";
                        String filiacion = (row.getCell(18) != null)?row.getCell(18).getStringCellValue():"";
                        String dominio = (row.getCell(19) != null)?row.getCell(19).getStringCellValue():"";
                        String linea = (row.getCell(20) != null)?row.getCell(20).getStringCellValue():"";
                        String sublinea = (row.getCell(21) != null)?row.getCell(21).getStringCellValue():"";
                        String cedula1 = (row.getCell(22) != null)?row.getCell(22).getStringCellValue():"";
                        String cedula2 = (row.getCell(23) != null)?row.getCell(23).getStringCellValue():"";
                        String cedula3 = (row.getCell(24) != null)?row.getCell(24).getStringCellValue():"";
                        String cedula4 = (row.getCell(25) != null)?row.getCell(25).getStringCellValue():"";
                        String cedula5 = (row.getCell(26) != null)?row.getCell(26).getStringCellValue():"";
                        String tituloProyectoFci = (row.getCell(27) != null)?row.getCell(27).getStringCellValue():"";
                        String observacion = (row.getCell(28) != null)?row.getCell(28).getStringCellValue():"";

                        Optional<Usuario> usr1 = usuarioService.getByCedula(cedula1);
                        if (!usr1.isEmpty()){
                            docentes.add(usr1.get());
                        }
                        Optional<Usuario> usr2 = usuarioService.getByCedula(cedula2);
                        if (!usr2.isEmpty()){
                            docentes.add(usr2.get());
                        }
                        Optional<Usuario> usr3 = usuarioService.getByCedula(cedula3);
                        if (!usr3.isEmpty()){
                            docentes.add(usr3.get());
                        }
                        Optional<Usuario> usr4 = usuarioService.getByCedula(cedula4);
                        if (!usr4.isEmpty()){
                            docentes.add(usr4.get());
                        }
                        Optional<Usuario> usr5 = usuarioService.getByCedula(cedula5);
                        if (!usr5.isEmpty()){
                            docentes.add(usr5.get());
                        }
                        Articulo articulo = new Articulo(facultad,
                                codigoUg,
                                tipoPublicacion,
                                codigoPublicacion,
                                tituloPublicacion,
                                doi,
                                baseDatosindexada,
                                codigoISSN,
                                tipoIndexacion,
                                nombreRevista,
                                numeroRevista,
                                quartil,
                                srjJcr,
                                fechaPublicacion,
                                campoDetallado,
                                estado,
                                linkPublicacion,
                                linkRevista,
                                filiacion,
                                dominio,
                                linea,
                                sublinea,
                                //docentes,
                                tituloProyectoFci,
                                observacion);
                        articulo.setDocentes(docentes);
                        articuloRepository.save(articulo);
                    }
                }
                count ++;
            }
            sheet = workbook.getSheet("ponencias");
            count = 0;
            for (Row row : sheet) {
                //ArrayList<Usuario> docentes = new ArrayList<>();
                Set<Usuario> docentes = new HashSet<>();
                if (count > 0){
                    if(row != null){
                        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                        Date fecha = null;
                        try {
                            if (row.getCell(15).getStringCellValue() != "" || row.getCell(15).getStringCellValue() != null){
                                fecha = formatter.parse(row.getCell(15).getStringCellValue());
                            }
                        }catch (Exception e){
                            System.out.println(e);
                        }
                        String facultad = (row.getCell(0) != null)?row.getCell(0).getStringCellValue():"";
                        String codigoUg = (row.getCell(1) != null)?row.getCell(1).getStringCellValue():"";
                        String tipoPublicacion = (row.getCell(2) != null)?row.getCell(2).getStringCellValue():"";
                        String codigoPublicacion = (row.getCell(3) != null)?row.getCell(3).getStringCellValue():"";
                        String nombrePonencia = (row.getCell(4) != null)?row.getCell(4).getStringCellValue():"";
                        String doi = (row.getCell(5) != null)?row.getCell(5).getStringCellValue():"";
                        String nombreEvento = (row.getCell(6) != null)?row.getCell(6).getStringCellValue():"";
                        String baseDatosIndexada = (row.getCell(7) != null)?row.getCell(7).getStringCellValue():"";
                        String codigoIsbnIss = (row.getCell(8) != null)?row.getCell(8).getStringCellValue():"";
                        String tipoIndexacion = (row.getCell(9) != null)?row.getCell(9).getStringCellValue():"";
                        String edicionEvento = (row.getCell(10) != null)?row.getCell(10).getStringCellValue():"";
                        String organizadorEvento = (row.getCell(11) != null)?row.getCell(11).getStringCellValue():"";
                        String comiteCientifico = (row.getCell(12) != null)?row.getCell(12).getStringCellValue():"";
                        String pais = (row.getCell(13) != null)?row.getCell(13).getStringCellValue():"";
                        String ciudad = (row.getCell(14) != null)?row.getCell(14).getStringCellValue():"";
                        Date fechaPublicacion = fecha;
                        String quartil = (row.getCell(16) != null)?row.getCell(16).getStringCellValue():"";
                        String sjrJcr = (row.getCell(17) != null)?row.getCell(17).getStringCellValue():"";
                        double campoDetallado = (row.getCell(18) != null)? row.getCell(18).getNumericCellValue():0;
                        String linkPublicacion = (row.getCell(19) != null)?row.getCell(19).getStringCellValue():"";
                        String filiacionUg = (row.getCell(20) != null)?row.getCell(20).getStringCellValue():"";
                        String dominio = (row.getCell(21) != null)?row.getCell(21).getStringCellValue():"";
                        String linea = (row.getCell(22) != null)?row.getCell(22).getStringCellValue():"";
                        String sublinea = (row.getCell(23) != null)?row.getCell(23).getStringCellValue():"";
                        String cedula1 = (row.getCell(24) != null)?row.getCell(24).getStringCellValue():"";
                        String cedula2 = (row.getCell(25) != null)?row.getCell(25).getStringCellValue():"";
                        String cedula3 = (row.getCell(26) != null)?row.getCell(26).getStringCellValue():"";
                        String cedula4 = (row.getCell(27) != null)?row.getCell(27).getStringCellValue():"";
                        String cedula5 = (row.getCell(28) != null)?row.getCell(28).getStringCellValue():"";
                        String tituloProyectoFci = (row.getCell(29) != null)?row.getCell(29).getStringCellValue():"";
                        String observacion = (row.getCell(30) != null)?row.getCell(30).getStringCellValue():"";

                        Optional<Usuario> usr1 = usuarioService.getByCedula(cedula1);
                        if (!usr1.isEmpty()){
                            docentes.add(usr1.get());
                        }
                        Optional<Usuario> usr2 = usuarioService.getByCedula(cedula2);
                        if (!usr2.isEmpty()){
                            docentes.add(usr2.get());
                        }
                        Optional<Usuario> usr3 = usuarioService.getByCedula(cedula3);
                        if (!usr3.isEmpty()){
                            docentes.add(usr3.get());
                        }
                        Optional<Usuario> usr4 = usuarioService.getByCedula(cedula4);
                        if (!usr4.isEmpty()){
                            docentes.add(usr4.get());
                        }
                        Optional<Usuario> usr5 = usuarioService.getByCedula(cedula5);
                        if (!usr5.isEmpty()){
                            docentes.add(usr5.get());
                        }
                        Ponencia ponencia = new Ponencia(facultad,
                                codigoUg,
                                tipoPublicacion,
                                codigoPublicacion,
                                nombrePonencia,
                                doi,
                                nombreEvento,
                                baseDatosIndexada,
                                codigoIsbnIss,
                                tipoIndexacion,
                                edicionEvento,
                                organizadorEvento,
                                comiteCientifico,
                                pais,
                                ciudad,
                                fechaPublicacion,
                                quartil,
                                sjrJcr,
                                campoDetallado,
                                linkPublicacion,
                                filiacionUg,
                                dominio,
                                linea,
                                sublinea,
                                //docentes,
                                tituloProyectoFci,
                                observacion);
                        ponencia.setDocentes(docentes);
                        ponenciaRepository.save(ponencia);
                    }
                }
                count ++;
            }
            sheet = workbook.getSheet("libros");
            count = 0;
            for (Row row : sheet) {
                //ArrayList<Usuario> docentes = new ArrayList<>();
                Set<Usuario> docentes = new HashSet<>();
                if (count > 0){
                    if(row != null){
                        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                        Date fecha = null;
                        try {
                            if (row.getCell(8).getStringCellValue() != "" || row.getCell(8).getStringCellValue() != null){
                                fecha = formatter.parse(row.getCell(8).getStringCellValue());
                            }
                        }catch (Exception e){
                            System.out.println(e);
                        }
                        String facultad = (row.getCell(0) != null)?row.getCell(0).getStringCellValue():"";
                        String codigoUg = (row.getCell(1) != null)?row.getCell(1).getStringCellValue():"";
                        String tipoPublicacion = (row.getCell(2) != null)?row.getCell(2).getStringCellValue():"";
                        String codigoPublicacion = (row.getCell(3) != null)?row.getCell(3).getStringCellValue():"";
                        String tituloLibro = (row.getCell(4) != null)?row.getCell(4).getStringCellValue():"";
                        String codigoIsbn = (row.getCell(5) != null)?row.getCell(5).getStringCellValue():"";
                        String editorCompilador = (row.getCell(6) != null)?row.getCell(6).getStringCellValue():"";
                        String paginas = (row.getCell(7) != null)?row.getCell(7).getStringCellValue():"";
                        Date fechaPublicacion = fecha;
                        String linkPublicacion = (row.getCell(9) != null)?row.getCell(9).getStringCellValue():"";
                        double campoDetallado = (row.getCell(10) != null)?row.getCell(10).getNumericCellValue():0;
                        String filiacionUg = (row.getCell(11) != null)?row.getCell(11).getStringCellValue():"";
                        String revicionPorPares = (row.getCell(12) != null)?row.getCell(12).getStringCellValue():"";
                        String dominio = (row.getCell(13) != null)?row.getCell(13).getStringCellValue():"";
                        String linea = (row.getCell(14) != null)?row.getCell(14).getStringCellValue():"";
                        String sublinea = (row.getCell(15) != null)?row.getCell(15).getStringCellValue():"";
                        String cedula1 = (row.getCell(16) != null)?row.getCell(16).getStringCellValue():"";
                        String cedula2 = (row.getCell(17) != null)?row.getCell(17).getStringCellValue():"";
                        String cedula3 = (row.getCell(18) != null)?row.getCell(18).getStringCellValue():"";
                        String cedula4 = (row.getCell(19) != null)?row.getCell(19).getStringCellValue():"";
                        String cedula5 = (row.getCell(20) != null)?row.getCell(20).getStringCellValue():"";
                        String tituloProyectoFci = (row.getCell(21) != null)?row.getCell(21).getStringCellValue():"";
                        String observacion = (row.getCell(22) != null)?row.getCell(22).getStringCellValue():"";

                        Optional<Usuario> usr1 = usuarioService.getByCedula(cedula1);
                        if (!usr1.isEmpty()){
                            docentes.add(usr1.get());
                        }
                        Optional<Usuario> usr2 = usuarioService.getByCedula(cedula2);
                        if (!usr2.isEmpty()){
                            docentes.add(usr2.get());
                        }
                        Optional<Usuario> usr3 = usuarioService.getByCedula(cedula3);
                        if (!usr3.isEmpty()){
                            docentes.add(usr3.get());
                        }
                        Optional<Usuario> usr4 = usuarioService.getByCedula(cedula4);
                        if (!usr4.isEmpty()){
                            docentes.add(usr4.get());
                        }
                        Optional<Usuario> usr5 = usuarioService.getByCedula(cedula5);
                        if (!usr5.isEmpty()){
                            docentes.add(usr5.get());
                        }
                        Libro libro = new Libro(facultad,
                                codigoUg,
                                tipoPublicacion,
                                codigoPublicacion,
                                tituloLibro,
                                codigoIsbn,
                                editorCompilador,
                                paginas,
                                fechaPublicacion,
                                linkPublicacion,
                                campoDetallado,
                                filiacionUg,
                                revicionPorPares,
                                dominio,
                                linea,
                                sublinea,
                                //docentes,
                                tituloProyectoFci,
                                observacion);
                        libro.setDocentes(docentes);
                        libroRepository.save(libro);
                    }
                }
                count ++;
            }
            sheet = workbook.getSheet("capitulosLibro");
            count = 0;
            for (Row row : sheet) {
                //ArrayList<Usuario> docentes = new ArrayList<>();
                Set<Usuario> docentes = new HashSet<>();
                if (count > 0){
                    if(row != null){
                        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                        Date fecha = null;
                        try {
                            if (row.getCell(9).getStringCellValue() != "" || row.getCell(9).getStringCellValue() != null){
                                fecha = formatter.parse(row.getCell(9).getStringCellValue());
                            }
                        }catch (Exception e){
                            System.out.println(e);
                        }
                        String facultad = (row.getCell(0) != null)?row.getCell(0).getStringCellValue():"";
                        String codigoUg = (row.getCell(1) != null)?row.getCell(1).getStringCellValue():"";
                        String tipoPublicacion = (row.getCell(2) != null)?row.getCell(2).getStringCellValue():"";
                        String codigoPublicacion = (row.getCell(3) != null)?row.getCell(3).getStringCellValue():"";
                        String tituloLibro = (row.getCell(4) != null)?row.getCell(4).getStringCellValue():"";
                        String tituloCapitulo = (row.getCell(5) != null)?row.getCell(5).getStringCellValue():"";
                        String codigoIsbn = (row.getCell(6) != null)?row.getCell(6).getStringCellValue():"";
                        String editorCompilador = (row.getCell(7) != null)?row.getCell(7).getStringCellValue():"";
                        String paginas = (row.getCell(8) != null)?row.getCell(8).getStringCellValue():"";
                        Date fechaPublicacion = fecha;
                        String linkPublicacion = (row.getCell(10) != null)?row.getCell(10).getStringCellValue():"";
                        double campoDetallado = (row.getCell(11) != null)?row.getCell(11).getNumericCellValue():0;
                        String filiacionUg = (row.getCell(12) != null)?row.getCell(12).getStringCellValue():"";
                        String revicionPorPares = (row.getCell(13) != null)?row.getCell(13).getStringCellValue():"";
                        String dominio = (row.getCell(14) != null)?row.getCell(14).getStringCellValue():"";
                        String linea = (row.getCell(15) != null)?row.getCell(15).getStringCellValue():"";
                        String sublinea = (row.getCell(16) != null)?row.getCell(16).getStringCellValue():"";
                        String cedula1 = (row.getCell(17) != null)?row.getCell(17).getStringCellValue():"";
                        String cedula2 = (row.getCell(18) != null)?row.getCell(18).getStringCellValue():"";
                        String cedula3 = (row.getCell(19) != null)?row.getCell(19).getStringCellValue():"";
                        String cedula4 = (row.getCell(20) != null)?row.getCell(20).getStringCellValue():"";
                        String cedula5 = (row.getCell(21) != null)?row.getCell(21).getStringCellValue():"";
                        String tituloProyectoFci = (row.getCell(22) != null)?row.getCell(22).getStringCellValue():"";
                        String observacion = (row.getCell(23) != null)?row.getCell(23).getStringCellValue():"";

                        Optional<Usuario> usr1 = usuarioService.getByCedula(cedula1);
                        if (!usr1.isEmpty()){
                            docentes.add(usr1.get());
                        }
                        Optional<Usuario> usr2 = usuarioService.getByCedula(cedula2);
                        if (!usr2.isEmpty()){
                            docentes.add(usr2.get());
                        }
                        Optional<Usuario> usr3 = usuarioService.getByCedula(cedula3);
                        if (!usr3.isEmpty()){
                            docentes.add(usr3.get());
                        }
                        Optional<Usuario> usr4 = usuarioService.getByCedula(cedula4);
                        if (!usr4.isEmpty()){
                            docentes.add(usr4.get());
                        }
                        Optional<Usuario> usr5 = usuarioService.getByCedula(cedula5);
                        if (!usr5.isEmpty()){
                            docentes.add(usr5.get());
                        }
                        CapituloLibro capituloLibro = new CapituloLibro(facultad,
                                codigoUg,
                                tipoPublicacion,
                                codigoPublicacion,
                                tituloLibro,
                                tituloCapitulo,
                                codigoIsbn,
                                editorCompilador,
                                paginas,
                                fechaPublicacion,
                                linkPublicacion,
                                campoDetallado,
                                filiacionUg,
                                revicionPorPares,
                                dominio,
                                linea,
                                sublinea,
                                //docentes,
                                tituloProyectoFci,
                                observacion);
                        capituloLibro.setDocentes(docentes);
                        capituloLibroRepository.save(capituloLibro);
                    }
                }
                count ++;
            }
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public List<Articulo> getAllArticulos(){
        return (List<Articulo>) articuloRepository.findAll();
    }
    public Articulo saveArticulo(Articulo articulo){
        return articuloRepository.save(articulo);
    }
    public List<Ponencia> getAllPonencias(){
        return (List<Ponencia>) ponenciaRepository.findAll();
    }
    public Ponencia savePonencia(Ponencia ponencia){
        return ponenciaRepository.save(ponencia);
    }
    public List<Libro> getAllLibros(){
        return (List<Libro>) libroRepository.findAll();
    }
    public Libro saveLibro(Libro libro){
        return libroRepository.save(libro);
    }

    public List<CapituloLibro> getAllCapituloLibro(){
        return (List<CapituloLibro>) capituloLibroRepository.findAll();
    }

    public CapituloLibro saveCapituloLibro(CapituloLibro capituloLibro){
        return capituloLibroRepository.save(capituloLibro);
    }

    //REPORTES ARTICULOS
    public List<Articulo> getAllArticulosByFilter(String tipoPublicacion,String codigoPublicacion, String fechaPublicacion){

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date dInicio = null;
        try {
            dInicio = formatter.parse(fechaPublicacion);
        }catch (Exception e){
            System.out.println(e);
        }
        return (List<Articulo>) articuloRepository.findByTipoPublicacionOrCodigoPublicacionOrFechaPublicacion(tipoPublicacion,codigoPublicacion,dInicio);

    }
    public List<Articulo> getAllArticulosByFilterAndDocente(String tipoPublicacion,String codigoPublicacion, String fechaPublicacion, long docente){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date dInicio = null;
        try {
            dInicio = formatter.parse(fechaPublicacion);
        }catch (Exception e){
            System.out.println(e);
        }
        List<Articulo> articulos = (List<Articulo>) articuloRepository.findByTipoPublicacionOrCodigoPublicacionOrFechaPublicacion(tipoPublicacion,codigoPublicacion,dInicio);
        List<Articulo> articulosByDocente = new ArrayList<>();
        for (Articulo articulo: articulos) {
            for(Usuario docnt: articulo.getDocentes()){
                if( docnt.getId() == docente){
                    articulosByDocente.add(articulo);
                }
            }
        }
        return articulosByDocente;
    }

    public List<Articulo> getAllArticulosByDocente(long docente){
        List<Articulo> articulos = (List<Articulo>) articuloRepository.findAll();
        List<Articulo> articulosByDocente = new ArrayList<>();
        for (Articulo articulo: articulos) {
            for(Usuario docnt: articulo.getDocentes()){
                if( docnt.getId() == docente){
                    articulosByDocente.add(articulo);
                }
            }
        }
        return articulosByDocente;
    }

    //REPORTES PONENCIA
    public List<Ponencia> getAllPonenciasByFilter(String tipoPublicacion,String codigoPublicacion, String fechaPublicacion){

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date dInicio = null;
        try {
            dInicio = formatter.parse(fechaPublicacion);
        }catch (Exception e){
            System.out.println(e);
        }
        return (List<Ponencia>) ponenciaRepository.findByTipoPublicacionOrCodigoPublicacionOrFechaPublicacion(tipoPublicacion,codigoPublicacion,dInicio);

    }
    public List<Ponencia> getAllPonenciasByFilterAndDocente(String tipoPublicacion,String codigoPublicacion, String fechaPublicacion, long docente){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date dInicio = null;
        try {
            dInicio = formatter.parse(fechaPublicacion);
        }catch (Exception e){
            System.out.println(e);
        }
        List<Ponencia> ponencias = (List<Ponencia>) ponenciaRepository.findByTipoPublicacionOrCodigoPublicacionOrFechaPublicacion(tipoPublicacion,codigoPublicacion,dInicio);
        List<Ponencia> ponenciasByDocente = new ArrayList<>();
        for (Ponencia ponencia: ponencias) {
            for(Usuario docnt: ponencia.getDocentes()){
                if( docnt.getId() == docente){
                    ponenciasByDocente.add(ponencia);
                }
            }
        }
        return ponenciasByDocente;
    }
    public List<Ponencia> getAllPonenciasByDocente(long docente){
        List<Ponencia> ponencias = (List<Ponencia>) ponenciaRepository.findAll();
        List<Ponencia> poneneicasByDocente = new ArrayList<>();
        for (Ponencia ponencia: ponencias) {
            for(Usuario docnt: ponencia.getDocentes()){
                if( docnt.getId() == docente){
                    poneneicasByDocente.add(ponencia);
                }
            }
        }
        return poneneicasByDocente;
    }

    //REPORTES LIBRO
    public List<Libro> getAllLibrosByFilter(String tipoPublicacion,String codigoPublicacion, String fechaPublicacion){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date dInicio = null;
        try {
            dInicio = formatter.parse(fechaPublicacion);
        }catch (Exception e){
            System.out.println(e);
        }
        return (List<Libro>) libroRepository.findByTipoPublicacionOrCodigoPublicacionOrFechaPublicacion(tipoPublicacion,codigoPublicacion,dInicio);

    }
    public List<Libro> getAllLibrosByFilterAndDocente(String tipoPublicacion,String codigoPublicacion, String fechaPublicacion, long docente){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date dInicio = null;
        try {
            dInicio = formatter.parse(fechaPublicacion);
        }catch (Exception e){
            System.out.println(e);
        }
        List<Libro> libros = (List<Libro>) libroRepository.findByTipoPublicacionOrCodigoPublicacionOrFechaPublicacion(tipoPublicacion,codigoPublicacion,dInicio);
        List<Libro> librosByDocente = new ArrayList<>();
        for (Libro libro: libros) {
            for(Usuario docnt: libro.getDocentes()){
                if( docnt.getId() == docente){
                    librosByDocente.add(libro);
                }
            }
        }
        return librosByDocente;
    }
    public List<Libro> getAllLibrosByDocente(long docente){
        List<Libro> libros = (List<Libro>) libroRepository.findAll();
        List<Libro> librosByDocente = new ArrayList<>();
        for (Libro libro: libros) {
            for(Usuario docnt: libro.getDocentes()){
                if( docnt.getId() == docente){
                    librosByDocente.add(libro);
                }
            }
        }
        return librosByDocente;
    }

    //REPORTES CAPITULO-LIBRO
    public List<CapituloLibro> getAllCapitulosLibroByFilter(String tipoPublicacion,String codigoPublicacion, String fechaPublicacion){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date dInicio = null;
        try {
            dInicio = formatter.parse(fechaPublicacion);
        }catch (Exception e){
            System.out.println(e);
        }
        return (List<CapituloLibro>) capituloLibroRepository.findByTipoPublicacionOrCodigoPublicacionOrFechaPublicacion(tipoPublicacion,codigoPublicacion,dInicio);

    }
    public List<CapituloLibro> getAllCapitulosLibroByFilterAndDocente(String tipoPublicacion,String codigoPublicacion, String fechaPublicacion, long docente){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date dInicio = null;
        try {
            dInicio = formatter.parse(fechaPublicacion);
        }catch (Exception e){
            System.out.println(e);
        }
        List<CapituloLibro> capitulosLibro = (List<CapituloLibro>) capituloLibroRepository.findByTipoPublicacionOrCodigoPublicacionOrFechaPublicacion(tipoPublicacion,codigoPublicacion,dInicio);
        List<CapituloLibro> capitulosLibroByDocente = new ArrayList<>();
        for (CapituloLibro capitulo: capitulosLibro) {
            for(Usuario docnt: capitulo.getDocentes()){
                if( docnt.getId() == docente){
                    capitulosLibroByDocente.add(capitulo);
                }
            }
        }
        return capitulosLibroByDocente;
    }
    public List<CapituloLibro> getAllCapitulosLibroByDocente(long docente){
        List<CapituloLibro> capitulosLibro = (List<CapituloLibro>) capituloLibroRepository.findAll();
        List<CapituloLibro> capitulosLibroByDocente = new ArrayList<>();
        for (CapituloLibro capitulo: capitulosLibro) {
            for(Usuario docnt: capitulo.getDocentes()){
                if( docnt.getId() == docente){
                    capitulosLibroByDocente.add(capitulo);
                }
            }
        }
        return capitulosLibroByDocente;
    }

}
