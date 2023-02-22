package com.Kplus1.appuntesapi.entities;

import lombok.Data;

import javax.persistence.*;

@Table(name = "materias")
@Entity
@Data
public class Materia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "id_materia_fk", nullable = false)
    private Integer idMateriaFk;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_materia_fk", insertable = false, updatable = false)
    private MateriaUniversidad materiaUniversidad;

    @Column(name = "id_estudiante_fk", nullable = false)
    private Integer idEstudianteFk;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estudiante_fk", insertable = false, updatable = false)
    private Estudiante estudiante;

    @Column(name = "creditos", nullable = false)
    private Boolean creditos;

    @Column(name = "profesor", nullable = false)
    private String profesor;
}
