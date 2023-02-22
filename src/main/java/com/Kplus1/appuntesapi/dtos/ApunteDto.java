package com.Kplus1.appuntesapi.dtos;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ApunteDto {
    private Integer id;
    private Integer idGrupoApunte;
    private GrupoApunteDto grupoApunte;
    private LocalDateTime fechaCreacion;
    private String titulo;
    private String contenido;
    private String tipoContenido;
}
