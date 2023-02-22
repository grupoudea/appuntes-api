package com.Kplus1.appuntesapi.entities;

import lombok.Data;

import javax.persistence.*;

@Table(name = "estudiantes")
@Entity
@Data
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "identificacion", nullable = false)
    private String identificacion;

    @Column(name = "correo", nullable = false)
    private String correo;

    @Column(name = "celular", nullable = false)
    private String celular;
}
