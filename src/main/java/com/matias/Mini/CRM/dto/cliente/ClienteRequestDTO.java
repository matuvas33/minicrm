package com.matias.Mini.CRM.dto.cliente;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record ClienteRequestDTO(
        @NotBlank(message = "El nombre es obligatorio")
        String nombre,
        @NotBlank(message = "El email es obligatorio!")
        @Email(message = "No es el formato correcto!")
        String email,
        @NotBlank(message = "El telefono es obligatorio!")
        String telefono,
        @NotBlank(message = "La empresa es obligatoria!")
        String empresa
) {
}
