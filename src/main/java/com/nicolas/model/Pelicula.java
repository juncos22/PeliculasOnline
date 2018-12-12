package com.nicolas.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Entity
@Table(name = "peliculas")
public class Pelicula {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "nombre")
    @NotNull
    private String nombre;

    @Column(name = "genero")
    @NotNull
    private String genero;

    @Column(name = "fecha")
    @NotNull
    private Date fecha;

    @Column(name = "portada")
    @NotNull
    private String portada;

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

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getPortada() {
        return portada;
    }

    public void setPortada(String portada) {
        this.portada = portada;
    }

    public Pelicula() {
    }

    public Pelicula(@NotNull String nombre, @NotNull String genero, @NotNull Date fecha, @NotNull String portada) {
        this.nombre = nombre;
        this.genero = genero;
        this.fecha = fecha;
        this.portada = portada;
    }
}
