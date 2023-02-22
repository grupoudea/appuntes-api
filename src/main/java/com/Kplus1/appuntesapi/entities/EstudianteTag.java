package com.Kplus1.appuntesapi.entities;

import lombok.Data;

import javax.persistence.*;

@Table(name = "estudiantes_tag")
@Entity
@Data
public class EstudianteTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "id_estudiante_fk", nullable = false)
    private Integer idEstudianteFk;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estudiante_fk", insertable = false, updatable = false)
    private Estudiante estudiante;

    @Column(name = "id_tag_fk", nullable = false)
    private Integer idTagFk;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tag_fk", insertable = false, updatable = false)
    private Tag tag;
}
