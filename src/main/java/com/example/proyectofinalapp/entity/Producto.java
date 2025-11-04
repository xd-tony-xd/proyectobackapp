package com.example.proyectofinalapp.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    private String titulo;
    private String descripcion;
    private Double precio;
    private Integer stock = 1;
    private String imagenUrl;
    private Double latitud;
    private Double longitud;
    private String direccion;

    @Enumerated(EnumType.STRING)
    private EstadoProducto estado = EstadoProducto.DISPONIBLE;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPublicacion = new Date();

    public enum EstadoProducto {
        DISPONIBLE, VENDIDO, PAUSADO
    }
}
