package com.Kplus1.appuntesapi.dtos;

import lombok.Data;

import javax.validation.constraints.Null;
import java.time.LocalDateTime;

@Data
public class ApunteDto {
    private Integer id;
    private Integer idGrupoApunte;
    private GrupoApunteDto grupoApunte;
    private LocalDateTime fechaCreacion;
    @Null
    private String titulo;
    private String contenido;
    private String tipoContenido;
}
