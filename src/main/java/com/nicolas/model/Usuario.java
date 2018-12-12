package com.nicolas.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true)
    @NotNull
    private int id;

    @Column(name = "nombre")
    @NotNull
    private String nombre;

    @Column(name = "contrasena")
    @NotNull
    private String contrasena;

    public int getId() {
        return id;
    }

    public void setDni(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Usuario() {
    }

    public Usuario(@NotNull String nombre, @NotNull String contrasena) {
        this.nombre = nombre;
        this.contrasena = contrasena;
    }
}
