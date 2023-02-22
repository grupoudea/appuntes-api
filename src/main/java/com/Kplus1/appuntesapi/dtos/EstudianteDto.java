package com.Kplus1.appuntesapi.dtos;

import lombok.Data;

@Data
public class EstudianteDto {
    private Integer id;
    private String nombre;
    private String identificacion;
    private String correo;
    private String celular;
}
