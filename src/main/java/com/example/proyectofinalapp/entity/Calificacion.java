package com.example.proyectofinalapp.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "calificaciones")
public class Calificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "calificador_id")
    private Usuario calificador;

    @ManyToOne
    @JoinColumn(name = "calificado_id")
    private Usuario calificado;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;

    private Double puntuacion;
    private String comentario;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha = new Date();
}
