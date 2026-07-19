package com.omjr.act3_t4.controllers;

import com.omjr.act3_t4.entities.Autor;
import com.omjr.act3_t4.services.AutorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/autores")
public class AutorController {


    @Autowired
    private AutorService autorService;


    @GetMapping
    public String listar(Model model){

        model.addAttribute("autores", autorService.obtenerTodos());

        return "autores/lista";
    }


    @GetMapping("/nuevo")
    public String nuevo(Model model){

        model.addAttribute("autor", new Autor());

        return "autores/formulario";
    }


    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Autor autor){

        autorService.guardar(autor);

        return "redirect:/autores";
    }


    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id){

        autorService.eliminar(id);

        return "redirect:/autores";
    }
}