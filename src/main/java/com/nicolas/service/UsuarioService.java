package com.nicolas.service;

import com.nicolas.model.Usuario;
import com.nicolas.repository.UsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepo repo;

    public Usuario getUsuario(String nombre, String contrasena){
        return repo.findByNombreAndContrasena(nombre, contrasena);
    }

    public Usuario getUsuarioByNombre(String nombre){
        return repo.findByNombre(nombre);
    }
}
