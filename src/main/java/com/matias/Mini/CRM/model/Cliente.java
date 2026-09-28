package com.matias.Mini.CRM.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String nombre;
    @Column(unique = true,nullable = false)
    private String email;
    @Column(nullable = false)
    private String telefono;
    @Column(nullable = false)
    private String empresa;
    @Column(nullable = false)
    private boolean activo = true;


    public Cliente(String nombre,String email, String telefono, String empresa) {
        this.nombre=nombre;
        this.email = email;
        this.telefono = telefono;
        this.empresa = empresa;
    }

}
