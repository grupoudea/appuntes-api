package com.Kplus1.appuntesapi.entities;

import lombok.Data;

import javax.persistence.*;

@Table(name = "materias_universidad")
@Entity
@Data
public class MateriaUniversidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "codigo", nullable = false)
    private String codigo;

    @Column(name = "materia", nullable = false)
    private String materia;

    @Column(name = "numero_pensum", nullable = false)
    private Integer numeroPensum;
}
