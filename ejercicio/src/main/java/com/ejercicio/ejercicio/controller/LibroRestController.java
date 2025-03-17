package com.ejercicio.ejercicio.controller;

import com.ejercicio.ejercicio.model.Libro;
import com.ejercicio.ejercicio.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class LibroRestController {

    @Autowired
    private LibroRepository libroRepository;

    @GetMapping("/libros")
    public List<Libro> getAllLibros() {
        return libroRepository.findAll();
    }

    @GetMapping("/libros/{id}")
    public ResponseEntity<Libro> getLibroById(@PathVariable Long id) {
        return libroRepository.findById(id)
                .map(libro -> ResponseEntity.ok().body(libro))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/libros")
    public Libro createLibro(@RequestBody Libro libro) {
        return libroRepository.save(libro);
    }

    @PutMapping("/libros/{id}")
    public ResponseEntity<Libro> updateLibro(@PathVariable Long id, @RequestBody Libro libroDetails) {
        return libroRepository.findById(id)
                .map(libro -> {
                    libro.setTitulo(libroDetails.getTitulo());
                    libro.setDescripcion(libroDetails.getDescripcion());
                    libro.setEjemplaresVendidos(libroDetails.getEjemplaresVendidos());
                    Libro updatedLibro = libroRepository.save(libro);
                    return ResponseEntity.ok().body(updatedLibro);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/libros/{id}")
    public ResponseEntity<?> deleteLibro(@PathVariable Long id) {
        return libroRepository.findById(id)
                .map(libro -> {
                    libroRepository.delete(libro);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/libros/{id}/purchase")
    public ResponseEntity<Libro> purchaseLibro(@PathVariable Long id) {
        return libroRepository.findById(id)
                .map(libro -> {
                    libro.setEjemplaresVendidos(libro.getEjemplaresVendidos() + 1);
                    Libro updatedLibro = libroRepository.save(libro);
                    return ResponseEntity.ok().body(updatedLibro);
                })
                .orElse(ResponseEntity.notFound().build());
    }
} 