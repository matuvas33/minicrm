package com.matias.Mini.CRM.dto.notaseguimiento;

import java.time.LocalDateTime;

public record NotaSeguimientoResponseDTO (
        Long id,
        Long idCliente,
        String texto,
        LocalDateTime fecha
){
}
