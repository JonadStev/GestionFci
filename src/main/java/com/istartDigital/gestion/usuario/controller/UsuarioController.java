package com.istartDigital.gestion.usuario.controller;


import com.istartDigital.security.dto.LoginUsuario;
import com.istartDigital.security.model.Usuario;
import com.istartDigital.security.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("gestion")
@CrossOrigin
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    PasswordEncoder passwordEncoder;

    //@PreAuthorize("hasRole('ROLE_SUPERVISOR')")
    @GetMapping("/usuario/all")
    public List<Usuario> getUsers() {
        return usuarioService.getAllUser();
    }

    @GetMapping("/usuario/all/{estado}")
    public List<Usuario> getUsersByStatus(@PathVariable("estado") String estado) {
        return usuarioService.getUserByStatus(estado);
    }

    @GetMapping("/usuario/all/investigadores")
    public List<Usuario> getInvestigadores() {
        return usuarioService.getInvestigadoresActivos();
    }

    @GetMapping("/usuario/all/directores")
    public List<Usuario> getDirectores() {
        return usuarioService.getDirectores();
    }

    //@PreAuthorize("hasRole('ROLE_SUPERVISOR')")
    @PostMapping("/usuario/save")
    public Usuario saveUser(@RequestBody Usuario usuario){
        String password = "";
        if (usuario.getId() == 0) {
            password = passwordEncoder.encode(usuario.getPassword());
            usuario.setPassword(password);
        }
        return usuarioService.save(usuario);
    }

    @PostMapping("/usuario/resetPassword")
    public Map<String, String> resetPassword(@RequestBody LoginUsuario loginUsuario){
        Map<String, String> map = new HashMap<>();
        try {
            if(usuarioService.existsByEmail(loginUsuario.getNombreUsuario())){
                Usuario usuario = usuarioService.getByNombreUsuario(loginUsuario.getNombreUsuario()).get();
                usuario.setPassword(passwordEncoder.encode(loginUsuario.getPassword()));
                usuarioService.save(usuario);
                map.put("mensaje","Su contraseña ha sido modificada exitosamente.");
            }else {
                map.put("mensaje","No existe el usuario en nuestra base de datos.");
            }
        }catch (Exception e){
            map.put("mensaje","Ha ocurrido un error en la actualización de contraseña.");
        }
        return map;
    }


}
