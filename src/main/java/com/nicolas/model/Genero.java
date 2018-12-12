package com.nicolas.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "generos")
public class Genero {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @NotNull
    private int id;

    @Column(name = "nombre")
    @NotNull
    private String nombre;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Genero() {
    }

    public Genero(@NotNull String nombre) {
        this.nombre = nombre;
    }
}
