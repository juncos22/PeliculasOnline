package com.nicolas.service;

import com.nicolas.model.Pelicula;
import com.nicolas.repository.PeliculaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeliculaService {

    @Autowired
    private PeliculaRepo repo;

    public List<Pelicula> findPeliculas(){
        return repo.findAll();
    }

    public void addPelicula(Pelicula pelicula){
        repo.save(pelicula);
    }

    public Pelicula getPelicula(String nombre){
        return repo.getPeliculaByNombre(nombre);
    }

    public void updatePelicula(Pelicula pelicula){
        repo.save(pelicula);
    }

    public void deletePelicula(Pelicula pelicula){
        repo.delete(pelicula);
    }
}
