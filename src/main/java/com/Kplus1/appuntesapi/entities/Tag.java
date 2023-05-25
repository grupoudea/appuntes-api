package com.Kplus1.appuntesapi.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name = "tags")
@Entity
@Data
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "fecha_creacion", nullable = false)
    private LocalDateTime fechaCreacion;

    @Column(name = "nombre", nullable = false)
    private String nombre;
}
