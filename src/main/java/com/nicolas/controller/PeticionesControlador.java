package com.nicolas.controller;

import com.nicolas.model.Genero;
import com.nicolas.model.Pelicula;
import com.nicolas.model.Usuario;
import com.nicolas.service.GeneroService;
import com.nicolas.service.PeliculaService;
import com.nicolas.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.List;

@Controller
public class PeticionesControlador {

    @Autowired
    private PeliculaService peliculaService;

    @Autowired
    private GeneroService generoService;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping(value = "/")
    public String goHome(Model model, HttpServletRequest request){
        List<Pelicula> peliculaList = peliculaService.findPeliculas();
        Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
        if (usuario != null){
            model.addAttribute("usuario", usuario);
        }
        model.addAttribute("title", "Home | Peliculas online");
        model.addAttribute("lstPeliculas", peliculaList);

        return "index";
    }

    @GetMapping(value = "/peliculas")
    public String peliculas(Model model, HttpServletRequest request){
        // Usuario usuario = usuarioService.getUsuarioByNombre(nombre);
        Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
        if (usuario != null){
            List<Genero> lstGeneros = generoService.findAll();
            model.addAttribute("generos", lstGeneros);
            return "new";
        }else {
            return login(model);
        }
    }

    @PostMapping(value = "/add")
    public String addMovie(Model model, HttpServletRequest request){
        String nombre = request.getParameter("nombre");
        String genero = request.getParameter("genero");
        Date fecha = Date.valueOf(request.getParameter("fecha"));
        String portada = request.getParameter("portada");

        Pelicula pelicula = new Pelicula();
        pelicula.setNombre(nombre);
        pelicula.setGenero(genero);
        pelicula.setFecha(fecha);
        pelicula.setPortada(portada);

        peliculaService.addPelicula(pelicula);
        model.addAttribute("msg", "Pelicula agregada");
        return goHome(model, request);
    }

    @GetMapping(value = "/login")
    public String login(Model model){
        return "login";
    }

    @PostMapping(value = "/signin")
    public String signin(Model model, HttpServletRequest request){
        String nombre = request.getParameter("nombre");
        String contrasena = request.getParameter("contrasena");
        Usuario usuario = usuarioService.getUsuario(nombre, contrasena);

        if (usuario != null){
            request.getSession().setAttribute("usuario", usuario);
            return goHome(model, request);
        }else {
            model.addAttribute("msg", "usuario o contraseña incorrectos");
            return "login";
        }
    }

    @GetMapping(value = "/logout")
    public String logout(Model model, HttpServletRequest request){
        request.getSession().removeAttribute("usuario");
        return goHome(model, request);
    }

    @GetMapping(value = "/search/{nombre}")
    public String search(@RequestParam String nombre, Model model){
        Pelicula pelicula = peliculaService.getPelicula(nombre);
        model.addAttribute("pelicula", pelicula);
        return "search";
    }
}
