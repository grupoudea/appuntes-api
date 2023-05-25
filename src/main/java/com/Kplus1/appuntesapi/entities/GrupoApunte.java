package com.Kplus1.appuntesapi.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name = "grupo_apuntes")
@Entity
@Data
public class GrupoApunte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "id_materia_fk", nullable = false)
    private Integer idMateriaFk;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_materia_fk", insertable = false, updatable = false)
    private Materia materia;

    @Column(name = "fecha_creacion", nullable = false)
    private LocalDateTime fechaCreacion;

    @Column(name = "nombre", nullable = false)
    private String nombre;
}
