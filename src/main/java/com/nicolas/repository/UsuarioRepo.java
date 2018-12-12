package com.nicolas.repository;

import com.nicolas.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepo extends JpaRepository<Usuario, Integer> {

    Usuario findByNombreAndContrasena(String nombre, String contrasena);
    Usuario findByNombre(String nombre);
}
