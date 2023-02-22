package com.Kplus1.appuntesapi.dtos;

import lombok.Data;


@Data
public class EstudianteTagDto {
    private Integer id;
    private Integer idEstudianteFk;
    private EstudianteDto estudiante;
    private Integer idTagFk;
    private TagDto tag;
}
