package com.istartDigital.security.service;

import com.istartDigital.security.model.Rol;
import com.istartDigital.security.model.Usuario;
import com.istartDigital.security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public Optional<Usuario> getByNombreUsuario(String nombreUsuario){
        return usuarioRepository.findByEmail(nombreUsuario);
    }

    public Optional<Usuario> getByCedula(String cedula){
        return usuarioRepository.findByCedula(cedula);
    }

    public boolean existsByEmail(String email){
        return usuarioRepository.existsByEmail(email);
    }

    public Usuario save(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public Usuario udpateUser(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> getAllUser(){
        return usuarioRepository.findAll();
    }

    public List<Usuario> getUserByStatus(String estado){
        return usuarioRepository.findByEstado(estado);
    }

    public List<Usuario> getInvestigadoresActivos(){
        List<Usuario> usuarios = this.getUserByStatus("ACTIVO");
        List<Usuario> investigadores = new ArrayList<>();
        for (Usuario u: usuarios) {
            if (u.getRoles().size() != 3) {
                for(Rol rol : u.getRoles()){
                    if (rol.getRolNombre().toString() == "ROLE_INVESTIGADOR"){
                        investigadores.add(u);
                    }
                }
            }
        }
        return investigadores;
    }

    public List<Usuario> getDirectores(){
        List<Usuario> usuarios = this.getUserByStatus("ACTIVO");
        List<Usuario> directores = new ArrayList<>();
        for (Usuario u: usuarios) {
            if (u.getRoles().size() != 3) {
                for(Rol rol : u.getRoles()){
                    if (rol.getRolNombre().toString() == "ROLE_DIRECTOR"){
                        directores.add(u);
                    }
                }
            }
        }
        return directores;
    }


}
