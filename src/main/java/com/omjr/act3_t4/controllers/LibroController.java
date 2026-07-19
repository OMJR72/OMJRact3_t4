package com.omjr.act3_t4.controllers;

import com.omjr.act3_t4.entities.Libro;
import com.omjr.act3_t4.services.LibrosService;
import com.omjr.act3_t4.services.AutorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/libros")
public class LibroController {

    @Autowired
    private LibrosService librosService;

    @Autowired
    private AutorService autorService;


    @GetMapping
    public String listar(Model model) {
        model.addAttribute("libros", librosService.obtenerTodos());
        return "libros/lista";
    }


    @GetMapping("/nuevo")
    public String nuevo(Model model) {

        model.addAttribute("libro", new Libro());
        model.addAttribute("autores", autorService.obtenerTodos());

        return "libros/formulario";
    }


    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Libro libro) {

        librosService.guardar(libro);

        return "redirect:/libros";
    }


    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {

        Libro libro = librosService.buscarPorId(id);
        if (libro != null) {
            librosService.eliminar(libro);
        }

        return "redirect:/libros";
    }
}