package com.nicolas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nicolas.model.Pelicula;

public interface PeliculaRepo extends JpaRepository<Pelicula, Integer> {

    Pelicula getPeliculaByNombre(String nombre);
}
