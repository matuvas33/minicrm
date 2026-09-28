package com.matias.Mini.CRM.dto.notaseguimiento;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record NotaSeguimientoRequestDTO (
        @NotNull
        Long idCliente,
        @NotBlank
        String texto
){
}
