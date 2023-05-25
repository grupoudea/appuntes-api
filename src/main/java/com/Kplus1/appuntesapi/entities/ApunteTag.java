package com.Kplus1.appuntesapi.entities;

import lombok.Data;

import javax.persistence.*;

@Table(name = "apuntes_tag")
@Entity
@Data
public class ApunteTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "id_apunte", nullable = false)
    private Integer idApunte;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_apunte", insertable = false, updatable = false)
    private Apunte apunte;

    @Column(name = "id_tag_fk", nullable = false)
    private Integer idTagFk;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tag_fk", insertable = false, updatable = false)
    private Tag tag;
}
