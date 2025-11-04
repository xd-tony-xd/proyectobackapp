package com.example.proyectofinalapp.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "mensajes")
public class Mensaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "remitente_id")
    private Usuario remitente;

    @ManyToOne
    @JoinColumn(name = "receptor_id")
    private Usuario receptor;

    private String contenido;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEnvio = new Date();

    private Boolean leido = false;
}
