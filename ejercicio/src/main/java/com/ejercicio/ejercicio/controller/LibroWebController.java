package com.ejercicio.ejercicio.controller;

import com.ejercicio.ejercicio.model.Libro;
import com.ejercicio.ejercicio.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/libros")
public class LibroWebController {

    @Autowired
    private LibroService libroService;

    @GetMapping
    public String listarLibros(Model model) {
        model.addAttribute("libros", libroService.obtenerTodosLosLibros());
        return "lista-libros";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevoLibro(Model model) {
        Libro libro = new Libro();
        libro.setEjemplaresVendidos(0);
        model.addAttribute("libro", libro);
        return "formulario-libro";
    }

    @PostMapping("/nuevo")
    public String crearLibro(@ModelAttribute("libro") Libro libro) {
        libroService.crearLibro(libro);
        return "redirect:/libros";
    }

    @GetMapping("/{id}/editar")
    public String mostrarFormularioEditarLibro(@PathVariable Long id, Model model) {
        try {
            Libro libro = libroService.obtenerLibroPorId(id);
            model.addAttribute("libro", libro);
            return "formulario-libro";
        } catch (Exception e) {
            return "redirect:/libros";
        }
    }

    @PostMapping("/{id}/editar")
    public String actualizarLibro(@PathVariable Long id, @ModelAttribute("libro") Libro libro) {
        libroService.actualizarLibro(id, libro);
        return "redirect:/libros";
    }

    @PostMapping("/{id}/eliminar")
    public String eliminarLibro(@PathVariable Long id) {
        libroService.eliminarLibro(id);
        return "redirect:/libros";
    }

    @PostMapping("/{id}/comprar")
    public String comprarLibro(@PathVariable Long id) {
        libroService.comprarLibro(id);
        return "redirect:/libros";
    }
} 