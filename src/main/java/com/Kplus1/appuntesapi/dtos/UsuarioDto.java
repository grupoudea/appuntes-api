package com.Kplus1.appuntesapi.dtos;

import lombok.Data;

@Data
public class UsuarioDto {
    private Integer id;
    private String nombreUsuario;
    private String password;
    private Boolean estado;
    private Integer idEstudianteFk;
    private EstudianteDto estudiante;
}
