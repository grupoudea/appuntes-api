package com.Kplus1.appuntesapi.entities;

import lombok.Data;

import javax.persistence.*;

@Table(name = "usuarios")
@Entity
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "usuario", nullable = false, unique = true)
    private String nombreUsuario;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "estado", nullable = false)
    private Boolean estado;

    @Column(name = "id_estudiante_fk", nullable = false)
    private Integer idEstudianteFk;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estudiante_fk", insertable = false, updatable = false)
    private Estudiante estudiante;
}
