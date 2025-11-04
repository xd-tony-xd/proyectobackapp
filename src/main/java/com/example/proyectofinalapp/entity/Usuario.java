package com.example.proyectofinalapp.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;
    private String email;
    private String password;
    private String telefono;
    private String dni;
    private String direccion;
    private String ciudad;

    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;

    @Column(name = "foto_perfil")
    private String fotoPerfil;

    private Double reputacion = 5.0;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_registro")
    private Date fechaRegistro = new Date();
}
