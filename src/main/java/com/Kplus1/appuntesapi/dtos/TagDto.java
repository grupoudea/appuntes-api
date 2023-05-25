package com.Kplus1.appuntesapi.dtos;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TagDto {
    private Integer id;
    private LocalDateTime fechaCreacion;
    private String nombre;
}
