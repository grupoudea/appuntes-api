package com.Kplus1.appuntesapi.dtos;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class GrupoApunteDto {
    private Integer id;
    private Integer idMateriaFk;
    private MateriaDto materia;
    private LocalDateTime fechaCreacion;
    private String nombre;
}
