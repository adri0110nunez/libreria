package com.ejercicio.ejercicio.service;

import com.ejercicio.ejercicio.model.Libro;
import com.ejercicio.ejercicio.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;

    public List<Libro> obtenerTodosLosLibros() {
        return libroRepository.findAll();
    }

    public Libro obtenerLibroPorId(Long id) {
        return libroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Libro no encontrado"));
    }

    @Transactional
    public Libro crearLibro(Libro libro) {
        return libroRepository.save(libro);
    }

    @Transactional
    public Libro actualizarLibro(Long id, Libro libroActualizado) {
        Libro libro = obtenerLibroPorId(id);
        libro.setTitulo(libroActualizado.getTitulo());
        libro.setDescripcion(libroActualizado.getDescripcion());
        return libroRepository.save(libro);
    }

    @Transactional
    public void eliminarLibro(Long id) {
        libroRepository.deleteById(id);
    }

    @Transactional
    public Libro comprarLibro(Long id) {
        Libro libro = obtenerLibroPorId(id);
        libro.setEjemplaresVendidos(libro.getEjemplaresVendidos() + 1);
        return libroRepository.save(libro);
    }
} 