package com.nicolas.service;

import com.nicolas.model.Genero;
import com.nicolas.repository.GeneroRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneroService {

    @Autowired
    private GeneroRepo repo;

    public List<Genero> findAll(){
        return repo.findAll();
    }
}
