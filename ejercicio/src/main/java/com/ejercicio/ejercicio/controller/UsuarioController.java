package com.ejercicio.ejercicio.controller;

import com.ejercicio.ejercicio.model.TipoUsuario;
import com.ejercicio.ejercicio.model.Usuario;
import com.ejercicio.ejercicio.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Usuario> crearUsuario(
            @RequestParam String nombre,
            @RequestParam String email,
            @RequestParam TipoUsuario tipoUsuario,
            @RequestParam String identificadorEspecifico) {
        return ResponseEntity.ok(usuarioService.crearUsuario(nombre, email, tipoUsuario, identificadorEspecifico));
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> obtenerTodosLosUsuarios() {
        return ResponseEntity.ok(usuarioService.obtenerTodosLosUsuarios());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obtenerUsuarioPorId(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioService.obtenerUsuarioPorId(id));
    }
} 