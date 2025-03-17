package com.ejercicio.ejercicio.service;

import com.ejercicio.ejercicio.model.Administrador;
import com.ejercicio.ejercicio.model.TipoUsuario;
import com.ejercicio.ejercicio.model.Usuario;
import com.ejercicio.ejercicio.model.UsuarioNormal;
import com.ejercicio.ejercicio.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional
    public Usuario crearUsuario(String nombre, String email, TipoUsuario tipoUsuario, String identificadorEspecifico) {
        if (usuarioRepository.existsByEmail(email)) {
            throw new RuntimeException("Ya existe un usuario con ese email");
        }

        Usuario usuario;
        if (tipoUsuario == TipoUsuario.NORMAL) {
            UsuarioNormal usuarioNormal = new UsuarioNormal();
            usuarioNormal.setNumeroSocio(identificadorEspecifico);
            usuario = usuarioNormal;
        } else {
            Administrador administrador = new Administrador();
            administrador.setIdentificadorEmpleado(identificadorEspecifico);
            usuario = administrador;
        }

        usuario.setNombre(nombre);
        usuario.setEmail(email);
        usuario.setTipoUsuario(tipoUsuario);

        return usuarioRepository.save(usuario);
    }

    public List<Usuario> obtenerTodosLosUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario obtenerUsuarioPorId(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }
} 