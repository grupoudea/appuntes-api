package com.Kplus1.appuntesapi.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name = "apuntes")
@Entity
@Data
public class Apunte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "id_grupo_apunte", nullable = false)
    private Integer idGrupoApunte;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_grupo_apunte", insertable = false, updatable = false)
    private GrupoApunte grupoApunte;

    @Column(name = "fecha_creacion", nullable = false)
    private LocalDateTime fechaCreacion;

    @Column(name = "titulo", nullable = false)
    private String titulo;

    @Column(name = "contenido", nullable = false)
    private String contenido;

    @Column(name = "tipo_contenido", nullable = false)
    private String tipoContenido;
}
