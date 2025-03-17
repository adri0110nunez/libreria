package com.ejercicio.ejercicio.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo = "";

    @Column(nullable = false, length = 1000)
    private String descripcion = "";

    @Column(name = "ejemplares_vendidos", nullable = false)
    private Integer ejemplaresVendidos = 0;

    // Constructor con campos obligatorios
    public Libro(String titulo, String descripcion) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.ejemplaresVendidos = 0;
    }
} 