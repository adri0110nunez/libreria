package com.ejercicio.ejercicio.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@DiscriminatorValue("ADMINISTRADOR")
public class Administrador extends Usuario {
    @Column(name = "identificador_empleado", nullable = false)
    private String identificadorEmpleado;
} 