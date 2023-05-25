package com.Kplus1.appuntesapi.dtos;

import lombok.Data;

@Data
public class MateriaDto {
    private Integer id;
    private Integer idMateriaFk;
    private MateriaUniversidadDto materiaUniversidad;
    private Integer idEstudianteFk;
    private EstudianteDto estudiante;
    private Integer creditos;
    private String profesor;
}
