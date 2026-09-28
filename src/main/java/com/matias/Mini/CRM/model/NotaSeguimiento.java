package com.matias.Mini.CRM.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class NotaSeguimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_cliente",nullable = false)
    private Cliente cliente;
    @Column(columnDefinition = "TEXT")
    private String texto;
    @Column(nullable = false,updatable = false)
    private LocalDateTime fecha;

    public NotaSeguimiento(Cliente cliente, String texto, LocalDateTime fecha) {
        this.cliente = cliente;
        this.texto = texto;
        this.fecha = fecha;
    }
}
