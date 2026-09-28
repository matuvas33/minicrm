package com.matias.Mini.CRM.dto.cliente;

public record ClienteResponseDTO(
        Long id,
        String nombre,
        String email,
        String telefono,
        String empresa,
        boolean activo
) {
}
