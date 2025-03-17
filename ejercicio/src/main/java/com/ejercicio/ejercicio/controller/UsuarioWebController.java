package com.ejercicio.ejercicio.controller;

import com.ejercicio.ejercicio.model.TipoUsuario;
import com.ejercicio.ejercicio.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/usuarios")
public class UsuarioWebController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/registro")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("tiposUsuario", TipoUsuario.values());
        return "registro-usuario";
    }

    @PostMapping("/registro")
    public String registrarUsuario(
            @RequestParam String nombre,
            @RequestParam String email,
            @RequestParam TipoUsuario tipoUsuario,
            @RequestParam String identificadorEspecifico,
            Model model) {
        try {
            usuarioService.crearUsuario(nombre, email, tipoUsuario, identificadorEspecifico);
            return "redirect:/usuarios/lista";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            model.addAttribute("tiposUsuario", TipoUsuario.values());
            return "registro-usuario";
        }
    }

    @GetMapping("/lista")
    public String listarUsuarios(Model model) {
        model.addAttribute("usuarios", usuarioService.obtenerTodosLosUsuarios());
        return "lista-usuarios";
    }
} 