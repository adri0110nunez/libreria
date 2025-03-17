package com.ejercicio.ejercicio.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@DiscriminatorValue("NORMAL")
public class UsuarioNormal extends Usuario {
    @Column(name = "numero_socio", nullable = false)
    private String numeroSocio;
} 